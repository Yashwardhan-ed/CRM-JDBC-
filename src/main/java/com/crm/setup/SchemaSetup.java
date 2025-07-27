package com.crm.setup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaSetup {

    public void createAllTables(Connection conn) {
        System.out.println("Starting database schema creation...");
        createRoleTable(conn);
        createUserTable(conn);
        createLeadTable(conn);
        createLeadConversionTable(conn);
        createCustomerTable(conn);
        createOpportunityTable(conn);
        createOpportunityStageHistoryTable(conn);
        createProductTable(conn);   
        createOpportunityProductTable(conn);
        createContactTable(conn);
        createContactInteractionTable(conn);
        createInteractionTypeTable(conn);
        createInteractionTable(conn);
        createTaskTable(conn);
        createTaskDependencyTable(conn);
        createTaskAssignmentTable(conn);
        createForecastTable(conn);
        createPipelineSnapshotTable(conn);
        createMonthlyLeadConversionTable(conn);
        createCustomerInteractionSummaryTable(conn);
        createUserOverdueTasksTable(conn);
        createUserPerformanceTable(conn);
        System.out.println("All tables created successfully.");
        System.out.println("Schema creation process finished.");
    }


    private void createRoleTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Role ("+
            "RoleID       INT AUTO_INCREMENT PRIMARY KEY,"+
            "RoleName     VARCHAR(50) NOT NULL"+
        ")"; 
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Role' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Role' table: " + e.getMessage());
        }
    }

    private void createUserTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS User ("+
            "UserID       INT AUTO_INCREMENT PRIMARY KEY,"+
            "  FullName     VARCHAR(100),"+
            "  Email        VARCHAR(100) UNIQUE,"+
            "  RoleID       INT NOT NULL,"+
            "  FOREIGN KEY (RoleID) REFERENCES Role(RoleID)"+
        ")"; 
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'User' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'User' table: " + e.getMessage());
        }
    }
    private void createLeadTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Lead ("+
            "LeadID       INT AUTO_INCREMENT PRIMARY KEY,"+
            "FirstName    VARCHAR(50),"+
            "LastName     VARCHAR(50),"+
            "Email        VARCHAR(100),"+
            "Phone        VARCHAR(20),"+
            "Company      VARCHAR(100),"+
            "Status       VARCHAR(50),"+
            "CreatedAt    DATETIME DEFAULT CURRENT_TIMESTAMP,"+
            "INDEX idx_lead_status_created (Status, CreatedAt)"+
        ")"; 
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Lead' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Lead' table: " + e.getMessage());
        }
    }
    private void createLeadConversionTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS LeadConversion ("+
            "ConversionID     INT AUTO_INCREMENT PRIMARY KEY,"+
            "LeadID           INT NOT NULL,"+
            "OpportunityID    INT NOT NULL,"+
            "Description      TEXT,"+
            "ConversionDate   DATE,"+
            // FIX: Changed "Leads" to "Lead" to match the actual table name
            "FOREIGN KEY (LeadID)        REFERENCES Lead(LeadID),"+
            "FOREIGN KEY (OpportunityID) REFERENCES Opportunity(OpportunityID),"+
            "INDEX idx_convert_date (ConversionDate)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'LeadConversion' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'LeadConversion' table: " + e.getMessage());
        }
    }
    private void createCustomerTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Customer ("+
            "CustomerID   INT AUTO_INCREMENT PRIMARY KEY,"+
            "CompanyName  VARCHAR(100),"+
            "Industry     VARCHAR(100),"+
            "Location     VARCHAR(100),"+
            "Email        VARCHAR(100),"+
            "Phone        VARCHAR(20),"+
            "CreatedAt    DATETIME DEFAULT CURRENT_TIMESTAMP,"+
            "INDEX idx_customer_created (CreatedAt)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Customer' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Customer' table: " + e.getMessage());
        }
    }
    private void createOpportunityTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Opportunity ("+
            "OpportunityID      INT AUTO_INCREMENT PRIMARY KEY,"+
            "CustomerID         INT NOT NULL,"+
            "Stage              VARCHAR(50),"+
            "Value              DECIMAL(15,2),"+
            "ExpectedCloseDate  DATE,"+
            "CreatedAt          DATETIME DEFAULT CURRENT_TIMESTAMP,"+
            "OwnerID            INT NOT NULL,"+
            "FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),"+
            "FOREIGN KEY (OwnerID)   REFERENCES User(UserID),"+
            "INDEX idx_opp_stage_close (Stage, ExpectedCloseDate),"+
            "INDEX idx_opp_owner_stage (OwnerID, Stage, CreatedAt)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Opportunity' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Opportunity' table: " + e.getMessage());
        }
    }
    private void createOpportunityStageHistoryTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS OpportunityStageHistory ("+
            "HistoryID       INT AUTO_INCREMENT PRIMARY KEY,"+
            "OpportunityID   INT NOT NULL,"+
            "PreviousStage   VARCHAR(50),"+
            "NewStage        VARCHAR(50),"+
            "ChangedAt       DATETIME DEFAULT CURRENT_TIMESTAMP,"+
            "ChangedBy       INT NOT NULL,"+
            "FOREIGN KEY (OpportunityID) REFERENCES Opportunity(OpportunityID),"+
            "FOREIGN KEY (ChangedBy) REFERENCES User(UserID),"+
            "INDEX idx_opp_stage_history (OpportunityID, ChangedAt)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'OpportunityStageHistory' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'OpportunityStageHistory' table: " + e.getMessage());
        }
    }
    private void createProductTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Product ("+
            "ProductID INT PRIMARY KEY,"+
            "ProductName VARCHAR(255),"+
            "Description TEXT,"+
            "Price DECIMAL(10,2),"+
            "Category VARCHAR(100),"+
            "CreatedAt DATETIME"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Product' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Product' table: " + e.getMessage());
        }
    }
    private void createOpportunityProductTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS OpportunityProduct ("+
            "OpportunityID INT,"+
            "ProductID INT,"+
            "Quantity INT DEFAULT 1,"+
            "UnitPrice DECIMAL(10,2),"+
            "Discount DECIMAL(10,2),"+
            "PRIMARY KEY (OpportunityID, ProductID),"+
            "FOREIGN KEY (OpportunityID) REFERENCES Opportunity(OpportunityID),"+
            "FOREIGN KEY (ProductID) REFERENCES Product(ProductID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'OpportunityProduct' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'OpportunityProduct' table: " + e.getMessage());
        }
    }
    private void createContactTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Contact ("+
            "ContactID    INT AUTO_INCREMENT PRIMARY KEY,"+
            "FirstName    VARCHAR(50),"+
            "LastName     VARCHAR(50),"+
            "Email        VARCHAR(100),"+
            "Phone        VARCHAR(20),"+
            "Position     VARCHAR(50),"+
            "CustomerID   INT NOT NULL,"+
            "FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),"+
            "INDEX idx_contact_customer (CustomerID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Contact' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Contact' table: " + e.getMessage());
        }
    }
    private void createContactInteractionTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS ContactInteraction ("+
            "ContactID INT,"+
            "InteractionID INT,"+
            "PRIMARY KEY (ContactID, InteractionID),"+
            "FOREIGN KEY (ContactID) REFERENCES Contact(ContactID),"+
            "FOREIGN KEY (InteractionID) REFERENCES Interaction(InteractionID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'ContactInteraction' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'ContactInteraction' table: " + e.getMessage());
        }
    }
    private void createInteractionTypeTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS InteractionType ("+
            "TypeID        INT AUTO_INCREMENT PRIMARY KEY,"+
            "TypeName      VARCHAR(50) NOT NULL"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'InteractionType' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'InteractionType' table: " + e.getMessage());
        }
    }
    private void createInteractionTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Interaction ("+
            "InteractionID   INT AUTO_INCREMENT PRIMARY KEY,"+
            "CustomerID      INT NOT NULL,"+
            "ContactID       INT NOT NULL,"+
            "TypeID          INT NOT NULL,"+
            "Subject         VARCHAR(100),"+
            "Notes           TEXT,"+
            "InteractionDate DATETIME,"+
            "CreatedBy       INT NOT NULL,"+
            "FOREIGN KEY (CustomerID)  REFERENCES Customer(CustomerID),"+
            "FOREIGN KEY (ContactID)   REFERENCES Contact(ContactID),"+
            "FOREIGN KEY (CreatedBy)   REFERENCES User(UserID),"+
            "FOREIGN KEY (TypeID)      REFERENCES InteractionType(TypeID),"+
            "INDEX idx_int_customer_date (CustomerID, InteractionDate),"+
            "INDEX idx_int_contact_date  (ContactID, InteractionDate),"+
            "INDEX idx_int_type_date     (TypeID, InteractionDate)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Interaction' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Interaction' table: " + e.getMessage());
        }
    }
    private void createTaskTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Task ("+
            "TaskID              INT AUTO_INCREMENT PRIMARY KEY,"+
            "Title               VARCHAR(100),"+
            "Description         TEXT,"+
            "RelatedOpportunityID INT,"+
            "DueDate             DATE,"+
            "Status              ENUM('pending', 'completed', 'overdue') DEFAULT 'pending',"+
            "CreatedAt           DATETIME DEFAULT CURRENT_TIMESTAMP,"+
            "FOREIGN KEY (RelatedOpportunityID) REFERENCES Opportunity(OpportunityID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Task' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Task' table: " + e.getMessage());
        }
    }
    private void createTaskDependencyTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS TaskDependency ("+
            "TaskID INT NOT NULL,"+
            "DependsOnTaskID INT NOT NULL,"+
            "PRIMARY KEY (TaskID, DependsOnTaskID),"+
            "FOREIGN KEY (TaskID) REFERENCES Task(TaskID),"+
            "FOREIGN KEY (DependsOnTaskID) REFERENCES Task(TaskID),"+
            "CHECK (TaskID <> DependsOnTaskID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'TaskDependency' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'TaskDependency' table: " + e.getMessage());
        }
    }
    private void createTaskAssignmentTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS TaskAssignment ("+
            "TaskID     INT NOT NULL,"+
            "UserID     INT NOT NULL,"+
            "PRIMARY KEY (TaskID, UserID),"+
            "FOREIGN KEY (TaskID) REFERENCES Task(TaskID),"+
            "FOREIGN KEY (UserID) REFERENCES User(UserID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'TaskAssignment' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'TaskAssignment' table: " + e.getMessage());
        }
    }
    private void createForecastTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS Forecast ("+
            "ForecastID     INT AUTO_INCREMENT PRIMARY KEY,"+
            "UserID         INT NOT NULL,"+
            "Month          DATE,"+
            "ExpectedSales  DECIMAL(15,2),"+
            "ActualSales    DECIMAL(15,2),"+
            "FOREIGN KEY (UserID) REFERENCES User(UserID),"+
            "INDEX idx_forecast_user_month (UserID, Month)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'Forecast' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'Forecast' table: " + e.getMessage());
        }
    }
    private void createPipelineSnapshotTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS PipelineSnapshot ("+
            "SnapshotDate      DATE         NOT NULL,"+
            "Stage             VARCHAR(50)  NOT NULL,"+
            "OpportunityCount  INT          NOT NULL,"+
            "TotalValue        DECIMAL(18,2) NOT NULL,"+
            "PRIMARY KEY (SnapshotDate, Stage)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'PipelineSnapshot' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'PipelineSnapshot' table: " + e.getMessage());
        }
    }
    private void createMonthlyLeadConversionTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS MonthlyLeadConversion ("+
            "YearMonth        CHAR(7)      NOT NULL,"+
            "ConvertedLeads   INT          NOT NULL,"+
            "PRIMARY KEY (YearMonth)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'MonthlyLeadConversion' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'MonthlyLeadConversion' table: " + e.getMessage());
        }
    }
    private void createCustomerInteractionSummaryTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS CustomerInteractionSummary ("+
            "CustomerID        INT          NOT NULL,"+
            "InteractionCount  INT          NOT NULL,"+
            "LastInteraction   DATETIME     NOT NULL,"+
            "PRIMARY KEY (CustomerID),"+
            "FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'CustomerInteractionSummary' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'CustomerInteractionSummary' table: " + e.getMessage());
        }
    }
    private void createUserOverdueTasksTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS UserOverdueTasks ("+
            "UserID           INT       NOT NULL,"+
            "OverdueCount     INT       NOT NULL,"+
            "PRIMARY KEY (UserID),"+
            "FOREIGN KEY (UserID) REFERENCES User(UserID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'UserOverdueTasks' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'UserOverdueTasks' table: " + e.getMessage());
        }
    } 
    private void createUserPerformanceTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS UserPerformance ("+
            "SnapshotDate     DATE         NOT NULL,"+
            "UserID           INT          NOT NULL,"+
            "ClosedWon        INT          NOT NULL,"+
            "TotalValue       DECIMAL(18,2) NOT NULL,"+
            "PRIMARY KEY (SnapshotDate, UserID),"+
            "FOREIGN KEY (UserID) REFERENCES User(UserID)"+
        ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'UserPerformance' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating 'UserPerformance' table: " + e.getMessage());
        }
    }
}