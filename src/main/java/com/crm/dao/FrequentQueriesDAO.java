package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crm.model.CustomerInteractionSummary;
import com.crm.model.MonthlyLeadConversion;
import com.crm.model.OpportunityByStage;
import com.crm.model.UserOverdueTasks;
import com.crm.model.UserPerformanceSummary;

public class FrequentQueriesDAO {

    /**
     * 1. Open opportunities by stage and potential value.
     */
    public List<OpportunityByStage> getOpenOpportunitiesByStage(Connection conn) throws SQLException {
        List<OpportunityByStage> results = new ArrayList<>();
        String sql = "SELECT Stage, COUNT(OpportunityID) AS NumberOfOpportunities, SUM(Value) AS TotalPotentialValue " +
                     "FROM Opportunity WHERE Stage NOT IN ('Closed Won', 'Closed Lost') " +
                     "GROUP BY Stage ORDER BY TotalPotentialValue DESC";
        
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                results.add(new OpportunityByStage(
                    rs.getString("Stage"),
                    rs.getInt("NumberOfOpportunities"),
                    rs.getBigDecimal("TotalPotentialValue")
                ));
            }
        }
        return results;
    }

    /**
     * 2. Leads converted to opportunities per month.
     */
    public List<MonthlyLeadConversion> getLeadsConvertedPerMonth(Connection conn) throws SQLException {
        List<MonthlyLeadConversion> results = new ArrayList<>();
        String sql = "SELECT conversionMonth, convertedLeads FROM MonthlyLeadConversion";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                results.add(new MonthlyLeadConversion(
                    rs.getString("conversionMonth"),
                    rs.getInt("convertedLeads")
                ));
            }
        }
        return results;
    }

    /**
     * 3. Interaction counts per customer account.
     */
    public List<CustomerInteractionSummary> getInteractionCountsByCustomer(Connection conn) throws SQLException {
        List<CustomerInteractionSummary> results = new ArrayList<>();
        String sql = "SELECT customerId, InteractionCount, lastInteraction FROM CustomerInteractionSummary";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                results.add(new CustomerInteractionSummary(
                    rs.getInt("customerId"),
                    rs.getInt("InteractionCount"),
                    rs.getTimestamp("lastInteraction").toLocalDateTime()
                ));
            }
        }
        return results;
    }

    /**
     * Gets a summary of overdue tasks for each user.
     */
    public List<UserOverdueTasks> getOverdueTaskSummaryByUser(Connection conn) throws SQLException {
        List<UserOverdueTasks> results = new ArrayList<>();
        String sql = "SELECT userId, overdueCount FROM UserOverdueTasks";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                results.add(new UserOverdueTasks(
                    rs.getInt("userId"),
                    rs.getInt("overdueCount")
                ));
            }
        }
        return results;
    }

    /**
     * 6. Top 5 sales performers by number of closed-won deals.
     */
    public List<UserPerformanceSummary> getTopPerformers(Connection conn) throws SQLException {
        List<UserPerformanceSummary> results = new ArrayList<>();
        String sql = "SELECT u.FullName, COUNT(o.OpportunityID) AS ClosedDealsCount, SUM(o.Value) AS TotalValueClosed " +
                     "FROM Opportunity o JOIN User u ON o.OwnerID = u.UserID " +
                     "WHERE o.Stage = 'Closed Won' GROUP BY u.UserID, u.FullName " +
                     "ORDER BY ClosedDealsCount DESC LIMIT 5";
        
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                results.add(new UserPerformanceSummary(
                    rs.getString("FullName"),
                    rs.getInt("ClosedDealsCount"),
                    rs.getBigDecimal("TotalValueClosed")
                ));
            }
        }
        return results;
    }
}