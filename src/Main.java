import developer.Developer;
import dicontainer.DiContainer;
import dicontainer.RegisterType;
import services.calculations.*;
import services.calculator.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        DiContainer container = new DiContainer();

        Developer.DebugMessage("Starting Registration");
        Developer.IndentDebugMessagesOnce();
        container.Register(AdditionCalculationService.class, RegisterType.Singleton);
        container.Register(SubtractionCalculationService.class, RegisterType.Singleton);
        container.Register(MultiplicationCalculatorService.class, RegisterType.Singleton);
        container.Register(DivisionCalculationService.class, RegisterType.Singleton);
        container.Register(ExponentialCalculationService.class, RegisterType.Singleton);
        Developer.DeindentDebugMessagesOnce();

        Developer.DebugMessage("Registering Calculator");
        Developer.IndentDebugMessagesOnce();
        container.Register(ICalculator.class, AWorseCalculator.class, RegisterType.Singleton);
        Developer.DeindentDebugMessagesOnce();

        Developer.DebugMessage("Resolving calculator with dependencies");
        Developer.IndentDebugMessagesOnce();
        var calculator = container.ResolveInstance(ICalculator.class);
        Developer.DeindentDebugMessagesOnce();

        Developer.DebugMessage("Calculating...");
        var res = calculator.Calculate(2, 3, 2);
        System.out.println("Calculated result: " + res);
    }
}