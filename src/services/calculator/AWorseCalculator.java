package services.calculator;

import services.calculations.*;

public class AWorseCalculator implements ICalculator {

    AdditionCalculationService add;
    SubtractionCalculationService sub;

    public AWorseCalculator(
            AdditionCalculationService additionCalculatorService,
            SubtractionCalculationService subtractionCalculationService
    )
    {
        this.add = additionCalculatorService;
        this.sub = subtractionCalculationService;
    }

    @Override
    public double Calculate(double a, double b, double c) {
        return add.Calculate(sub.Calculate(a, b), c);
    }
}
