-- Scenario 1: Apply a 1% Discount to Customers Over 60
DECLARE
    CURSOR c_customers IS
        SELECT c.customer_id, c.age, l.loan_id, l.interest_rate
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id;
BEGIN
    FOR v_rec IN c_customers LOOP
        IF v_rec.age > 60 THEN
            UPDATE Loans
            SET interest_rate = interest_rate - 1
            WHERE loan_id = v_rec.loan_id;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('1% interest rate discount applied to all customers over 60.');
END;
/

-- Scenario 2: Promote to VIP Status Based on Balance
DECLARE
    CURSOR c_all_customers IS
        SELECT customer_id, balance
        FROM Customers;
BEGIN
    FOR v_rec IN c_all_customers LOOP
        IF v_rec.balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = v_rec.customer_id;
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status flag set to TRUE for balances over $10,000.');
END;
/

-- Scenario 3: Send Reminders for Loans Due in 30 Days
DECLARE
    CURSOR c_loans IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id;
BEGIN
    FOR v_rec IN c_loans LOOP
        IF v_rec.due_date BETWEEN SYSDATE AND (SYSDATE + 30) THEN
            DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_rec.customer_name ||
                                 ', your loan (ID: ' || v_rec.loan_id ||
                                 ') is due on ' || TO_CHAR(v_rec.due_date, 'YYYY-MM-DD'));
        END IF;
    END LOOP;
END;
/