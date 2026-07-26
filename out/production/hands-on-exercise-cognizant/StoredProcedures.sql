-- Scenario 1: Process Monthly Interest for Savings Accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update balance for all accounts categorized as 'Savings'
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts.');
END ProcessMonthlyInterest;
/

-- Scenario 2: Update Employee Bonus Based on Department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Calculate and add the bonus to the current salary
    UPDATE Employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to department ' || p_department_id);
END UpdateEmployeeBonus;
/

-- Scenario 3: Transfer Funds Between Accounts
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_current_balance NUMBER;
BEGIN
    -- Fetch the current balance of the source account
    SELECT balance INTO v_current_balance
    FROM Accounts
    WHERE account_id = p_from_account;

    -- Check for sufficient funds
    IF v_current_balance >= p_amount THEN
        -- Deduct from the source account
        UPDATE Accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;

        -- Add to the destination account
        UPDATE Accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount ||
                             ' from Account ' || p_from_account ||
                             ' to Account ' || p_to_account);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
    END IF;

EXCEPTION
    -- Handle cases where the source account doesn't exist
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Source account does not exist.');
    -- Rollback any partial changes if an unexpected error occurs
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END TransferFunds;
/