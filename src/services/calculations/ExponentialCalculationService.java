package services.calculations;

public class ExponentialCalculationService implements CalculationService {
    @Override
    public double Calculate(double a, double b) {
        return Math.pow(a, b);
    }
}
