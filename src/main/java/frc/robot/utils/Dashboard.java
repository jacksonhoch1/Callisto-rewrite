package frc.robot.utils;

//import java utils
import java.util.function.Consumer;
import java.util.function.Supplier;

//import wpilib utils
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
    public static final Entry<Boolean>
        INTAKE_POSITION = Entry.getBooleanEntry("Intake Position", false);
    
    public static final Entry<Double>
        GYRO_POSITION = Entry.getDoubleEntry("Gyro Value", 0);
    
    public Dashboard() {};

    public static void putSendable(String name, Sendable sendable) {
        SmartDashboard.putData(name, sendable);
    }

    public static class Entry<T> {

        private final Supplier<T> getValue;
        private final Consumer<T> putValue;

        private Entry(Supplier<T> getValue, Consumer<T> putValue) {
            this.getValue = getValue;
            this.putValue = putValue;
        }

        public T get() {
            return getValue.get();
        }

        public void put(T newValue) {
            putValue.accept(newValue);
        }

        public static Entry<Boolean> getBooleanEntry(String name, boolean defaultValue) {
            SmartDashboard.putBoolean(name, defaultValue);
            return new Entry<Boolean>(() -> SmartDashboard.getBoolean(name, defaultValue), (x) -> SmartDashboard.putBoolean(name, x));
        }

        public static Entry<Double> getDoubleEntry(String name, double defaultValue) {
            SmartDashboard.putNumber(name, defaultValue);
            return new Entry<Double>(() -> SmartDashboard.getNumber(name, defaultValue), (x) -> SmartDashboard.putNumber(name, x));
        }
    }
}
