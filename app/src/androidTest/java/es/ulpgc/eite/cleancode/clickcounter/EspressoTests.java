package es.ulpgc.eite.cleancode.clickcounter;


import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;

@SuppressWarnings("deprecation")
@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspressoTests {


    @Rule
    public ActivityTestRule<MasterActivity> rule = 
        new ActivityTestRule<>(MasterActivity.class);

    private EspressoTestsSteps steps = new EspressoTestsSteps();


    private void rotateScreen() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());

            Thread.sleep(700);
            device.setOrientationLeft();
            Thread.sleep(700);
            device.setOrientationNatural();
            Thread.sleep(700);

        } catch (Exception e) {

        }

    }

    /*
    public void rotateScreen() {

        Context context = ApplicationProvider.getApplicationContext();
        int orientation = context.getResources().getConfiguration().orientation;
        Activity activity = rule.getActivity();

        if(orientation  == Configuration.ORIENTATION_PORTRAIT) {
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            );
        } else {
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            );
        }

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) { }
    }
    */

    @Test
    public void test01CrearContadorEnMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // When pulsar boton master
        steps.pulsarBotonMaster();
        // Then mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test02CrearContadorEnMaestroConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }
    
    @Test
    public void test03PulsarEnContadorDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // When pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test04PulsarEnContadorDeMaestroConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test05PulsarEnContadorDeDetalle() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
        // When pulsar boton detalle
        steps.pulsarBotonDetalle();
        // Then mostrar contador con valor "2"
        steps.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        steps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test06PulsarEnContadorDeDetalleConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
        // And pulsar boton detalle
        steps.pulsarBotonDetalle();
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "2"
        steps.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        steps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test07PulsarEnRegresarDeDetalle() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
        // And pulsar boton detalle
        steps.pulsarBotonDetalle();
        // And mostrar contador con valor "2"
        steps.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        steps.mostrarNumeroDeClicksConValorP1("2");
        // When pulsar boton regresar
        steps.pulsarBotonRegresar();
        // Then mostrar contador en lista en posicion "0" con valor "2"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }


    @Test
    public void test08PulsarEnRegresarDeDetalleConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        steps.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        steps.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
        // And pulsar boton detalle
        steps.pulsarBotonDetalle();
        // And mostrar contador con valor "2"
        steps.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        steps.mostrarNumeroDeClicksConValorP1("2");
        // And pulsar boton regresar
        steps.pulsarBotonRegresar();
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador en lista en posicion "0" con valor "2"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        // And mostrar lista con numero de contadores "1"
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    
    @Test
    public void test09CrearVariosContadoresEnMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // When pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // Then mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test10CrearVariosContadoresEnMaestroConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test11PulsarVariasVecesEnContadorDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // When pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
    }


    @Test
    public void test12PulsarVariasVecesEnContadorDeMaestroConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        steps.mostrarNumeroDeClicksConValorP1("1");
    }
    
    @Test
    public void test13PulsarVariasVecesEnContadoresDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // When pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void test14PulsarVariasVecesEnContadoresDeMaestroConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
    }
    
    @Test
    public void test15PulsarEnContadorDeDetalles() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And mostrar contador en lista en posicion "1" con valor "2"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "2");
        // And pulsar boton contador en posicion "1"
        steps.pulsarBotonContadorEnPosicionP1("1");
        // And mostrar contador con valor "3"
        steps.mostrarContadorConValorP1("3");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
        // When pulsar boton detalle
        steps.pulsarBotonDetalle();
        // Then mostrar contador con valor "4"
        steps.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "4"
        steps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test16PulsarEnContadorDeDetallesConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And mostrar contador en lista en posicion "1" con valor "2"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "2");
        // And pulsar boton contador en posicion "1"
        steps.pulsarBotonContadorEnPosicionP1("1");
        // And mostrar contador con valor "3"
        steps.mostrarContadorConValorP1("3");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
        // And pulsar boton detalle
        steps.pulsarBotonDetalle();
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "4"
        steps.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "4"
        steps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test17PulsarVariasVecesContadorDeDetalles() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
        // When pulsar boton detalle numero de veces "3"
        steps.pulsarBotonDetalleNumeroDeVecesP1("3");
        // Then mostrar contador con valor "4"
        steps.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "6"
        steps.mostrarNumeroDeClicksConValorP1("6");
    }
    
    @Test
    public void test18PulsarVariasVecesContadorDeDetallesConRotacion() {
        // Given  mostrar lista con numero de contadores "0"
        steps.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        steps.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        steps.pulsarBotonContadorEnPosicionP1("2");
        // And mostrar contador con valor "1"
        steps.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        steps.mostrarNumeroDeClicksConValorP1("3");
        // And pulsar boton detalle numero de veces "3"
        steps.pulsarBotonDetalleNumeroDeVecesP1("3");
        // When rotar pantalla
        rotateScreen();
        // Then mostrar contador con valor "4"
        steps.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "6"
        steps.mostrarNumeroDeClicksConValorP1("6");
    }
}