package sample;

import javafx.embed.swt.CustomTransferBuilder;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MainTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return CustomTransferBuilder.create(JavaArchive.class).addClass(Main.class).addAsManifestResource(EmptyAsset.INSTANCE);
    }

    @org.jboss.arquillian.container.test.api.Deployment
    public static org.jboss.shrinkwrap.api.spec.JavaArchive createDeployment1() {
        return org.jboss.shrinkwrap.api.ShrinkWrap.create(org.jboss.shrinkwrap.api.spec.JavaArchive.class).addAsManifestResource(org.jboss.shrinkwrap.api.asset.EmptyAsset.INSTANCE, "beans.xml");
    }
}
