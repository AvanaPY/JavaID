package services.calculations;

public class DivisionCalculationService implements CalculationService{
    @Override
    public double Calculate(double a, double b) {
        return a / b;
    }
}
