package services.calculations;

public class AdditionCalculationService implements CalculationService
{
    @Override
    public double Calculate(double a, double b) {
        return a + b;
    }
}
