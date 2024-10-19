package services.calculator;
import services.calculations.*;

public class Calculator implements ICalculator {

    AdditionCalculationService add;
    SubtractionCalculationService sub;
    MultiplicationCalculatorService mult;
    ExponentialCalculationService exp;
    DivisionCalculationService div;

    public Calculator(
            AdditionCalculationService additionCalculatorService,
            SubtractionCalculationService subtractionCalculationService,
            MultiplicationCalculatorService multiplicationCalculatorService,
            ExponentialCalculationService exponentialCalculatorService,
            DivisionCalculationService divisionCalculatorService
    ) {
        this.add = additionCalculatorService;
        this.sub = subtractionCalculationService;
        this.mult = multiplicationCalculatorService;
        this.exp = exponentialCalculatorService;
        this.div = divisionCalculatorService;
    }

    public double Calculate(double a, double b, double c)
    {
        var aa = add.Calculate(
                exp.Calculate(a, b),
                exp.Calculate(b, c));
        var ab = sub.Calculate(
                exp.Calculate(a, b),
                mult.Calculate(b, c)
        );
        return div.Calculate(aa, ab);
    }

}
