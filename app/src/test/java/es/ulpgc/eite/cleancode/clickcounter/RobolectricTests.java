package es.ulpgc.eite.cleancode.clickcounter;

import android.content.pm.ActivityInfo;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 30)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RobolectricTests {


    private ActivityController<MasterActivity> activityController;
    private MasterActivity activity;
    private RobolectricTestsSteps masterSteps;

    @Before
    public void setUp() {
        activityController = Robolectric.buildActivity(MasterActivity.class).setup();
        activity = activityController.get();
        masterSteps = new RobolectricTestsSteps(activity);
    }

    /**
     * Simula la rotación de pantalla cambiando la orientación y
     * ejecutando el ciclo de recreación de la actividad.
     */
    private void rotateScreen() {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        activityController.configurationChange();
    }

    @Test
    public void test01CrearContadorEnMaestro() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test02CrearContadorEnMaestroConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        rotateScreen();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test03PulsarEnContadorDeMaestro() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");

        // Capturar el Intent y lanzar DetailActivity para continuar la verificación
        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test04PulsarEnContadorDeMaestroConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");
        rotateScreen();

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test05PulsarEnContadorDeDetalle() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");

        detailSteps.pulsarBotonDetalle();
        detailSteps.mostrarContadorConValorP1("2");
        detailSteps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test06PulsarEnContadorDeDetalleConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");

        detailSteps.pulsarBotonDetalle();
        rotateScreen();
        detailSteps.mostrarContadorConValorP1("2");
        detailSteps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test07PulsarEnRegresarDeDetalle() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
        detailSteps.pulsarBotonDetalle();
        detailSteps.mostrarContadorConValorP1("2");
        detailSteps.mostrarNumeroDeClicksConValorP1("2");
        detailSteps.pulsarBotonRegresar();

        // Regresamos a MasterActivity y verificamos que se actualizó el contador en la lista
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test08PulsarEnRegresarDeDetalleConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMaster();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
        masterSteps.pulsarBotonContadorEnPosicionP1("0");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
        detailSteps.pulsarBotonDetalle();
        detailSteps.mostrarContadorConValorP1("2");
        detailSteps.mostrarNumeroDeClicksConValorP1("2");
        detailSteps.pulsarBotonRegresar();
        rotateScreen();

        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        masterSteps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test09CrearVariosContadoresEnMaestro() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test10CrearVariosContadoresEnMaestroConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        rotateScreen();
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test11PulsarVariasVecesEnContadorDeMaestro() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test12PulsarVariasVecesEnContadorDeMaestroConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");
        rotateScreen();

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test13PulsarVariasVecesEnContadoresDeMaestro() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void test14PulsarVariasVecesEnContadoresDeMaestroConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");
        rotateScreen();

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void test15PulsarEnContadorDeDetalles() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("1");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("3");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");

        detailSteps.pulsarBotonDetalle();
        detailSteps.mostrarContadorConValorP1("4");
        detailSteps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test16PulsarEnContadorDeDetallesConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("1");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("3");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");

        detailSteps.pulsarBotonDetalle();
        rotateScreen();
        detailSteps.mostrarContadorConValorP1("4");
        detailSteps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test17PulsarVariasVecesContadorDeDetalles() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");

        detailSteps.pulsarBotonDetalleNumeroDeVecesP1("3");
        detailSteps.mostrarContadorConValorP1("4");
        detailSteps.mostrarNumeroDeClicksConValorP1("6");
    }

    @Test
    public void test18PulsarVariasVecesContadorDeDetallesConRotacion() {
        masterSteps.mostrarListaConNumeroDeContadoresP1("0");
        masterSteps.pulsarBotonMasterNumeroDeVecesP1("3");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        masterSteps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        masterSteps.mostrarListaConNumeroDeContadoresP1("3");
        masterSteps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        masterSteps.pulsarBotonContadorEnPosicionP1("2");

        RobolectricTestsSteps detailSteps = masterSteps.obtenerDetailSteps();
        detailSteps.mostrarContadorConValorP1("1");
        detailSteps.mostrarNumeroDeClicksConValorP1("3");

        detailSteps.pulsarBotonDetalleNumeroDeVecesP1("3");
        rotateScreen();
        detailSteps.mostrarContadorConValorP1("4");
        detailSteps.mostrarNumeroDeClicksConValorP1("6");
    }
}
