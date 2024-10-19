import dicontainer.DIContainer;
import dicontainer.RegisterType;
import services.calculations.*;
import services.calculator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        DIContainer container = new DIContainer();
        container.Register(AdditionCalculationService.class, RegisterType.Singleton);
        container.Register(SubtractionCalculationService.class, RegisterType.Singleton);
        container.Register(MultiplicationCalculatorService.class, RegisterType.Singleton);
        container.Register(DivisionCalculationService.class, RegisterType.Singleton);
        container.Register(ExponentialCalculationService.class, RegisterType.Singleton);
        container.Register(ICalculator.class, Calculator.class, RegisterType.Singleton);

        var calculator = container.ResolveInstance(ICalculator.class);
        var res = calculator.Calculate(2, 3, 2);
        System.out.println("Calculated: " + res);
    }
}