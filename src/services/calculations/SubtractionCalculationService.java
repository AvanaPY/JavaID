package services.calculations;

public class SubtractionCalculationService implements CalculationService{
    @Override
    public double Calculate(double a, double b) {
        return a - b;
    }
}
