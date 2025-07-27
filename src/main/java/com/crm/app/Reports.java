package com.crm.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.util.List;

import com.crm.config.DatabaseConfig;
import com.crm.dao.FrequentQueriesDAO;
import com.crm.model.CustomerInteractionSummary;
import com.crm.model.MonthlyLeadConversion;
import com.crm.model.OpportunityByStage;
import com.crm.model.UserOverdueTasks;
import com.crm.model.UserPerformanceSummary;

public class Reports {

    public static void main(String[] args) {
        FrequentQueriesDAO reportingDAO = new FrequentQueriesDAO();

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)) {
            System.out.println("Successfully connected to the database. Running reports...\n");

            // Opportunity By Stage
            System.out.println("--- Report: Open Opportunities by Stage ---");
            List<OpportunityByStage> oppsByStage = reportingDAO.getOpenOpportunitiesByStage(conn);
            if (oppsByStage.isEmpty()) {
                System.out.println("No open opportunities found.");
            } else {
                oppsByStage.forEach(System.out::println);
            }
            System.out.println("-------------------------------------------\n");


            //  Leads converted per month
            System.out.println("--- Report: Leads Converted Per Month ---");
            List<MonthlyLeadConversion> monthlyConversions = reportingDAO.getLeadsConvertedPerMonth(conn);
            if (monthlyConversions.isEmpty()) {
                System.out.println("No lead conversions found.");
            } else {
                monthlyConversions.forEach(System.out::println);
            }
            System.out.println("-------------------------------------------\n");


            // Interaction counts for each customer
            System.out.println("--- Report: Top 10 Customers by Interaction Count ---");
            List<CustomerInteractionSummary> interactionCounts = reportingDAO.getInteractionCountsByCustomer(conn);
            if (interactionCounts.isEmpty()) {
                System.out.println("No customer interactions found.");
            } else {
                interactionCounts.forEach(summary -> 
                    System.out.printf("Customer ID: %-5d | Interactions: %-5d | Last Interaction: %s\n",
                        summary.getCustomerId(), summary.getInteractionCount(), summary.getLastInteraction())
                );
            }
            System.out.println("------------------------------------------------------\n");


            // Overdue tasks for each customer
            System.out.println("--- Report: Overdue Tasks per User ---");
            List<UserOverdueTasks> overdueTasks = reportingDAO.getOverdueTaskSummaryByUser(conn);
            if (overdueTasks.isEmpty()) {
                System.out.println("No overdue tasks found.");
            } else {
                overdueTasks.forEach(summary -> 
                    System.out.printf("User ID: %-5d | Overdue Tasks: %d\n", summary.getUserId(), summary.getOverdueCount())
                );
            }
            System.out.println("------------------------------------------\n");


            // top 5 Sales Performers
            System.out.println("--- Report: Top 5 Sales Performers ---");
            List<UserPerformanceSummary> topPerformers = reportingDAO.getTopPerformers(conn);
            if (topPerformers.isEmpty()) {
                System.out.println("No closed-won deals found.");
            } else {
                topPerformers.forEach(System.out::println);
            }
            System.out.println("------------------------------------------\n");


        } catch (SQLException e) {
            System.err.println("Database operation failed!");
            System.err.println(e.getMessage());
        }
    }
}
