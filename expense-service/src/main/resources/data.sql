-- Create Category Table
CREATE TABLE IF NOT EXISTS category (
category_id BIGINT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(50) NOT NULL UNIQUE
);

-- Insert predefined categories
INSERT INTO category (category_name) VALUES
('FOOD'),
('TRANSPORT'),
('ENTERTAINMENT'),
('GROCERIES'),
('UTILITIES'),
('HEALTHCARE'),
('EDUCATION'),
('SHOPPING'),
('SUBSCRIPTIONS'),
('RENT'),
('EMERGENCY'),
('TRAVEL'),
('GIFTS'),
('INVESTMENT'),
('LOAN_PAYMENT'),
('OTHER');

-- Create Expense Table
CREATE TABLE IF NOT EXISTS expense (
exp_id CHAR(36) PRIMARY KEY,
exp_amount DOUBLE NOT NULL,
category_id BIGINT NOT NULL,
expense_date DATE NOT NULL,
payment_method VARCHAR(100) NOT NULL,
exp_notes VARCHAR(200),
CONSTRAINT fk_category FOREIGN KEY (category_id)
REFERENCES category(category_id)
ON DELETE CASCADE
);

-- Example: Insert a sample expense
-- INSERT INTO expense (exp_id, exp_amount, category_id, expense_date, payment_method, exp_notes)
-- VALUES (UUID(), 50.0, 1, '2025-11-27', 'Credit Card', 'Lunch with friends');
