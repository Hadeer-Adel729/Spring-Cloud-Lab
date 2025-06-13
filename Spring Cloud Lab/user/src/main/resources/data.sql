CREATE TABLE `orders` (
                          `orderId` integer NOT NULL AUTO_INCREMENT,
                          `address` varchar(255) NOT NULL,
                          `date` datetime(6) NOT NULL,
                          `payType` enum('CASH','CREDIT') NOT NULL,
                          `price` DECIMAL(10,2) NOT NULL,
                          `status` enum('CANCELED','SHIPPED','COMPLETED','PROCESSING') NOT NULL,
                          `userId` integer NOT NULL,
                          PRIMARY KEY (`orderId`)
) ENGINE=InnoDB;


CREATE TABLE `product` (
                           `productId` integer NOT NULL AUTO_INCREMENT,
                           `description` varchar(255) NOT NULL,
                           `price` DECIMAL(10,2) NOT NULL,
                           `productName` varchar(255) NOT NULL,
                           `quantity` integer NOT NULL,
                            `orderId` integer NOT NULL,
                           PRIMARY KEY (`productId`)
) ENGINE=InnoDB;

CREATE TABLE `user` (
                        `userId` integer NOT NULL AUTO_INCREMENT,
                        `birthdate` date,
                        `creditLimit` DECIMAL(10,2),
                        `creditNo` varchar(255),
                        `email` varchar(255) NOT NULL,
                        `job` varchar(255),
                        `password` varchar(255) NOT NULL,
                        `phone` varchar(255),
                        `userName` varchar(255) NOT NULL,
                        PRIMARY KEY (`userId`)
) ENGINE=InnoDB;

-- Add foreign key constraints
ALTER TABLE `product` ADD CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`);
ALTER TABLE `orders` ADD CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);


-- Insert dummy users first (required for foreign key constraints)
INSERT INTO `user` (`userName`, `email`, `password`, `birthdate`, `phone`, `job`, `creditNo`, `creditLimit`) VALUES
                                                                                                                 ('john_smith', 'john.smith@email.com', 'hashed_password_123', '1985-03-15', '+1-555-0101', 'Software Engineer', '4532-1234-5678-9012', 5000),
                                                                                                                 ('sarah_jones', 'sarah.jones@email.com', 'hashed_password_456', '1990-07-22', '+1-555-0102', 'Marketing Manager', '4532-2345-6789-0123', 3000),
                                                                                                                 ('mike_davis', 'mike.davis@email.com', 'hashed_password_789', '1982-11-08', '+1-555-0103', 'Teacher', '4532-3456-7890-1234', 2500),
                                                                                                                 ('lisa_wilson', 'lisa.wilson@email.com', 'hashed_password_012', '1988-05-12', '+1-555-0104', 'Nurse', '4532-4567-8901-2345', 4000),
                                                                                                                 ('david_brown', 'david.brown@email.com', 'hashed_password_345', '1975-09-30', '+1-555-0105', 'Accountant', '4532-5678-9012-3456', 6000),
                                                                                                                 ('emma_taylor', 'emma.taylor@email.com', 'hashed_password_678', '1992-12-03', '+1-555-0106', 'Designer', '4532-6789-0123-4567', 3500),
                                                                                                                 ('alex_johnson', 'alex.johnson@email.com', 'hashed_password_901', '1987-01-18', '+1-555-0107', 'Chef', NULL, NULL),
                                                                                                                 ('maria_garcia', 'maria.garcia@email.com', 'hashed_password_234', '1993-08-25', '+1-555-0108', 'Student', '4532-7890-1234-5678', 1500);

-- Insert dummy orders
INSERT INTO `orders` (`address`, `date`, `payType`, `price`, `status`, `userId`) VALUES
                                                                                     ('123 Main St, New York, NY 10001', '2024-01-15 10:30:00.000000', 'CREDIT', 12999, 'COMPLETED', 1),
                                                                                     ('456 Oak Ave, Los Angeles, CA 90210', '2024-01-18 14:45:00.000000', 'CASH', 8750, 'SHIPPED', 2),
                                                                                     ('789 Pine Rd, Chicago, IL 60601', '2024-01-20 09:15:00.000000', 'CREDIT', 15600, 'PROCESSING', 3),
                                                                                     ('321 Elm St, Houston, TX 77001', '2024-01-22 16:20:00.000000', 'CREDIT', 4299, 'COMPLETED', 4),
                                                                                     ('654 Maple Dr, Phoenix, AZ 85001', '2024-01-25 11:10:00.000000', 'CASH', 9999, 'CANCELED', 5),
                                                                                     ('987 Cedar Ln, Philadelphia, PA 19101', '2024-01-28 13:55:00.000000', 'CREDIT', 6799, 'SHIPPED', 6),
                                                                                     ('147 Birch Way, San Antonio, TX 78201', '2024-02-01 08:30:00.000000', 'CASH', 2599, 'COMPLETED', 7),
                                                                                     ('258 Spruce St, San Diego, CA 92101', '2024-02-03 15:40:00.000000', 'CREDIT', 18999, 'PROCESSING', 8),
                                                                                     ('369 Willow Ave, Dallas, TX 75201', '2024-02-05 12:25:00.000000', 'CREDIT', 7499, 'COMPLETED', 1),
                                                                                     ('741 Aspen Rd, San Jose, CA 95101', '2024-02-08 17:15:00.000000', 'CASH', 11299, 'SHIPPED', 2);

-- Insert dummy products
INSERT INTO `product` (`productName`, `description`, `price`, `quantity`, `orderId`) VALUES
                                                                                         ('MacBook Pro 16"', 'Apple MacBook Pro 16-inch with M2 Pro chip', 24999, 1, 1),
                                                                                         ('iPhone 15 Pro', 'Latest iPhone with titanium design', 9999, 1, 1),
                                                                                         ('Samsung 65" QLED TV', '65-inch 4K QLED Smart TV', 12999, 1, 2),
                                                                                         ('Sony WH-1000XM5', 'Noise-canceling wireless headphones', 3499, 2, 2),
                                                                                         ('iPad Air', 'iPad Air with M1 chip, 64GB', 5999, 1, 3),
                                                                                         ('Apple Pencil', '2nd generation Apple Pencil', 1299, 1, 3),
                                                                                         ('Magic Keyboard', 'Magic Keyboard for iPad Air', 2999, 1, 3),
                                                                                         ('AirPods Pro', '2nd generation with MagSafe case', 2499, 1, 3),
                                                                                         ('Nintendo Switch OLED', 'Nintendo Switch OLED model console', 3499, 1, 4),
                                                                                         ('Super Mario Odyssey', 'Nintendo Switch game', 5999, 1, 4),
                                                                                         ('Dell XPS 13', 'Dell XPS 13 laptop with Intel i7', 13999, 1, 5),
                                                                                         ('Canon EOS R6', 'Mirrorless camera with 24-105mm lens', 24999, 1, 6),
                                                                                         ('Fitbit Charge 5', 'Advanced fitness tracker', 1999, 1, 7),
                                                                                         ('Kindle Oasis', 'Premium e-reader with adjustable warm light', 2999, 1, 7),
                                                                                         ('Surface Pro 9', 'Microsoft Surface Pro 9 tablet', 12999, 1, 8),
                                                                                         ('Surface Pen', 'Microsoft Surface Pen stylus', 999, 1, 8),
                                                                                         ('Surface Keyboard', 'Microsoft Surface Keyboard', 1299, 1, 8),
                                                                                         ('Bose QuietComfort 45', 'Wireless noise-canceling headphones', 3299, 1, 9),
                                                                                         ('Logitech MX Master 3', 'Advanced wireless mouse', 999, 1, 9),
                                                                                         ('Samsung Galaxy Watch 5', 'Smartwatch with health monitoring', 2799, 1, 9),
                                                                                         ('Google Nest Hub Max', 'Smart display with Google Assistant', 2299, 1, 10),
                                                                                         ('Philips Hue Starter Kit', 'Smart lighting starter kit', 1999, 1, 10),
                                                                                         ('Ring Video Doorbell', 'Smart doorbell with HD video', 1999, 1, 10);