public class FinancialForecasting {

    /**
     * Calculates the future value using a recursive algorithm.
     *
     * @param presentValue The initial amount.
     * @param growthRate The expected annual growth rate (e.g., 0.05 for 5%).
     * @param years The number of years into the future to predict.
     * @return The predicted future value.
     */
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If years is 0, the future value is just the present value.
        if (years <= 0) {
            return presentValue;
        }

        // Recursive Case: Calculate the value for the previous year and apply growth.
        return predictFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double currentRevenue = 100000.0; // $100,000
        double annualGrowthRate = 0.08;   // 8% growth rate based on past data
        int yearsToForecast = 5;          // Forecast 5 years into the future

        System.out.println("--- Financial Forecasting ---");
        System.out.printf("Present Value: $%.2f%n", currentRevenue);
        System.out.printf("Annual Growth Rate: %.0f%%%n", (annualGrowthRate * 100));
        System.out.println("Forecasting " + yearsToForecast + " years...");

        double predictedValue = predictFutureValue(currentRevenue, annualGrowthRate, yearsToForecast);

        System.out.printf("Predicted Future Value: $%.2f%n", predictedValue);
    }
}