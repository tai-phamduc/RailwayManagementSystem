create database TrainTicketBookingSystem
go

use TrainTicketBookingSystem

CREATE TABLE Employee (
    EmployeeID VARCHAR(50) PRIMARY KEY,  -- String in Java, VARCHAR in SQL
    FullName NVARCHAR(100) NOT NULL,     -- Supports Unicode characters (for names)
    Gender BIT NOT NULL,                 -- Boolean in Java, BIT in SQL (1 = Male, 0 = Female)
    DateOfBirth DATE NOT NULL,           -- LocalDate in Java, DATE in SQL
    Email VARCHAR(100) NOT NULL UNIQUE,  -- Email address with uniqueness constraint
    PhoneNumber VARCHAR(20) NULL,        -- Phone number is optional
    Role NVARCHAR(50) NOT NULL,          -- Role stored as a string
    StartingDate DATE NOT NULL,          -- Starting date of employment
    Salary DECIMAL(15, 2) NOT NULL,      -- Salary with 2 decimal precision
    ImageSource VARCHAR(255) NULL        -- Path to the image, optional
);

INSERT INTO Employee (EmployeeID, FullName, Gender, DateOfBirth, Email, PhoneNumber, Role, StartingDate, Salary, ImageSource) VALUES ('1', N'Pham Duc Tai', 1, '2003-10-27', 'phamductai102703', '0846107843', N'Manager', '2024-01-05', 1000, '/images/profile');

CREATE TABLE Account (
    Username NVARCHAR(50) NOT NULL PRIMARY KEY,    -- Username with uniqueness constraint
    Password NVARCHAR(255) NOT NULL,          -- Password (hashed for security in practice)
    EmployeeID VARCHAR(50) NOT NULL,          -- Foreign key referencing EmployeeID
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)  -- Foreign key constraint
);

INSERT INTO Account (Username, Password, EmployeeID) VALUES ('admin', '123', '1');
go

CREATE   FUNCTION [dbo].[getEmployeeByAccount](@user VARCHAR(50))
RETURNS TABLE
AS
RETURN
SELECT e.*
FROM Employee e JOIN Account a 
ON e.EmployeeID = a.EmployeeID
WHERE a.Username = @user;
GO

CREATE TABLE Train (
    TrainID INT PRIMARY KEY IDENTITY(1,1),       
    TrainNumber VARCHAR(50) NOT NULL,      
    Status NVARCHAR(50) NOT NULL              
);
GO

CREATE TABLE Coach (
    CoachID INT PRIMARY KEY IDENTITY(1,1),         
    CoachNumber INT NOT NULL,      
    CoachType NVARCHAR(50) NOT NULL,         
    Capacity INT NOT NULL,
    TrainID INT NOT NULL,              
    FOREIGN KEY (TrainID) REFERENCES Train(TrainID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO

CREATE TABLE Seat (
    SeatID INT PRIMARY KEY IDENTITY(1, 1),          
    SeatNumber INT NOT NULL,          
    CoachID INT NOT NULL,            
    FOREIGN KEY (CoachID) REFERENCES Coach(CoachID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
GO


INSERT INTO Train (TrainNumber, Status) VALUES ('SE1', 'Active')

INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (1, N'Ngồi mềm đều hòa', 64, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (2, N'Ngồi mềm đều hòa', 64, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (3, N'Giường nằm khoang 6 điều hòa', 42, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (4, N'Giường nằm khoang 6 điều hòa', 42, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (5, N'Giường nằm khoang 4 điều hòa', 28, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (6, N'Giường nằm khoang 4 điều hòa', 28, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (7, N'Giường nằm khoang 4 điều hòa', 28, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (8, N'Giường nằm khoang 4 điều hòa', 28, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (9, N'Giường nằm khoang 4 điều hòa', 28, 1)
INSERT INTO Coach (CoachNumber, CoachType, Capacity, TrainID) VALUES (10, N'Giường nằm khoang 4 điều hòa', 28, 1)

select * from coach
go

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 1), (2, 1), (3, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1), (10, 1), (11, 1), (12, 1), (13, 1), (14, 1), (15, 1), (16, 1), (17, 1), (18, 1), (19, 1), (20, 1), (21, 1), (22, 1), (23, 1), (24, 1), (25, 1), (26, 1), (27, 1), (28, 1), (29, 1), (30, 1), (31, 1), (32, 1), (33, 1), (34, 1), (35, 1), (36, 1), (37, 1), (38, 1), (39, 1), (40, 1), (41, 1), (42, 1), (43, 1), (44, 1), (45, 1), (46, 1), (47, 1), (48, 1), (49, 1), (50, 1), (51, 1), (52, 1), (53, 1), (54, 1), (55, 1), (56, 1), (57, 1), (58, 1), (59, 1), (60, 1), (61, 1), (62, 1), (63, 1), (64, 1);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 2), (2, 2), (3, 2), (5, 2), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2), (11, 2), (12, 2), (13, 2), (14, 2), (15, 2), (16, 2), (17, 2), (18, 2), (19, 2), (20, 2), (21, 2), (22, 2), (23, 2), (24, 2), (25, 2), (26, 2), (27, 2), (28, 2), (29, 2), (30, 2), (31, 2), (32, 2), (33, 2), (34, 2), (35, 2), (36, 2), (37, 2), (38, 2), (39, 2), (40, 2), (41, 2), (42, 2), (43, 2), (44, 2), (45, 2), (46, 2), (47, 2), (48, 2), (49, 2), (50, 2), (51, 2), (52, 2), (53, 2), (54, 2), (55, 2), (56, 2), (57, 2), (58, 2), (59, 2), (60, 2), (61, 2), (62, 2), (63, 2), (64, 2);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 3), (2, 3), (3, 3), (4, 3), (5, 3), (6, 3), (7, 3), (8, 3), (9, 3), (10, 3), (11, 3), (12, 3), (13, 3), (14, 3), (15, 3), (16, 3), (17, 3), (18, 3), (19, 3), (20, 3), (21, 3), (22, 3), (23, 3), (24, 3), (25, 3), (26, 3), (27, 3), (28, 3), (29, 3), (30, 3), (31, 3), (32, 3), (33, 3), (34, 3), (35, 3), (36, 3), (37, 3), (38, 3), (39, 3), (40, 3), (41, 3), (42, 3);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 4), (2, 4), (3, 4), (4, 4), (5, 4), (6, 4), (7, 4), (8, 4), (9, 4), (10, 4), (11, 4), (12, 4), (13, 4), (14, 4), (15, 4), (16, 4), (17, 4), (18, 4), (19, 4), (20, 4), (21, 4), (22, 4), (23, 4), (24, 4), (25, 4), (26, 4), (27, 4), (28, 4), (29, 4), (30, 4), (31, 4), (32, 4), (33, 4), (34, 4), (35, 4), (36, 4), (37, 4), (38, 4), (39, 4), (40, 4), (41, 4), (42, 4);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 5), (2, 5), (3, 5), (4, 5), (5, 5), (6, 5), (7, 5), (8, 5), (9, 5), (10, 5), (11, 5), (12, 5), (13, 5), (14, 5), (15, 5), (16, 5), (17, 5), (18, 5), (19, 5), (20, 5), (21, 5), (22, 5), (23, 5), (24, 5), (25, 5), (26, 5), (27, 5), (28, 5);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 6), (2, 6), (3, 6), (4, 6), (5, 6), (6, 6), (7, 6), (8, 6), (9, 6), (10, 6), (11, 6), (12, 6), (13, 6), (14, 6), (15, 6), (16, 6), (17, 6), (18, 6), (19, 6), (20, 6), (21, 6), (22, 6), (23, 6), (24, 6), (25, 6), (26, 6), (27, 6), (28, 6);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 7), (2, 7), (3, 7), (4, 7), (5, 7), (6, 7), (7, 7), (8, 7), (9, 7), (10, 7), (11, 7), (12, 7), (13, 7), (14, 7), (15, 7), (16, 7), (17, 7), (18, 7), (19, 7), (20, 7), (21, 7), (22, 7), (23, 7), (24, 7), (25, 7), (26, 7), (27, 7), (28, 7);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 8), (2, 8), (3, 8), (4, 8), (5, 8), (6, 8), (7, 8), (8, 8), (9, 8), (10, 8), (11, 8), (12, 8), (13, 8), (14, 8), (15, 8), (16, 8), (17, 8), (18, 8), (19, 8), (20, 8), (21, 8), (22, 8), (23, 8), (24, 8), (25, 8), (26, 8), (27, 8), (28, 8);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 9), (2, 9), (3, 9), (4, 9), (5, 9), (6, 9), (7, 9), (8, 9), (9, 9), (10, 9), (11, 9), (12, 9), (13, 9), (14, 9), (15, 9), (16, 9), (17, 9), (18, 9), (19, 9), (20, 9), (21, 9), (22, 9), (23, 9), (24, 9), (25, 9), (26, 9), (27, 9), (28, 9);

INSERT INTO Seat (SeatNumber, CoachID) VALUES (1, 10), (2, 10), (3, 10), (4, 10), (5, 10), (6, 10), (7, 10), (8, 10), (9, 10), (10, 10), (11, 10), (12, 10), (13, 10), (14, 10), (15, 10), (16, 10), (17, 10), (18, 10), (19, 10), (20, 10), (21, 10), (22, 10), (23, 10), (24, 10), (25, 10), (26, 10), (27, 10), (28, 10);

go

SELECT 
    t.TrainID, 
    t.TrainNumber, 
    COUNT(c.CoachID) AS NumberOfCoaches, 
    SUM(c.Capacity) AS TotalCapacity, 
    (SELECT COUNT(DISTINCT CoachType) FROM Coach) AS NumberOfCoachTypes,
    t.Status
FROM 
    Train t 
JOIN 
    Coach c ON t.TrainID = c.TrainID 
GROUP BY 
    t.TrainID, 
    t.TrainNumber, 
    t.Status;

go

CREATE FUNCTION dbo.GetAllTrainDetails()
RETURNS TABLE
AS
RETURN
(
    SELECT 
        t.TrainID,
        t.TrainNumber,
        COUNT(c.CoachID) AS NumberOfCoaches,
        SUM(c.Capacity) AS Capacity,
        COUNT(DISTINCT c.CoachType) AS NumberOfCoachTypes,
        STUFF((
            SELECT DISTINCT ', ' + c2.CoachType
            FROM Coach c2
            WHERE c2.TrainID = t.TrainID
            FOR XML PATH('')), 1, 2, '') AS CoachTypes,
        t.Status
    FROM 
        Train t
    LEFT JOIN 
        Coach c ON t.TrainID = c.TrainID
    GROUP BY 
        t.TrainID, t.TrainNumber, t.Status
);































