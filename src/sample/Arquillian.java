package sample;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class Arquillian extends Runner {
    @Override
    public Description getDescription() {
        return null;
    }

    @Override
    public void run(RunNotifier runNotifier) {

    }
}
