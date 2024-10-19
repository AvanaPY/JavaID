package services.calculations;

public class MultiplicationCalculatorService implements CalculationService{
    @Override
    public double Calculate(double a, double b) {
        return a * b;
    }
}
