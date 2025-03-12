package es.ulpgc.eite.cleancode.clickcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import org.robolectric.Robolectric;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;
import es.ulpgc.eite.cleancode.clickcounter.detail.DetailActivity;

public class RobolectricTestsSteps {

    private Activity activity;

    public RobolectricTestsSteps(Activity activity) {
        this.activity = activity;
    }

    public void mostrarListaConNumeroDeContadoresP1(String p1) {

        int expectedSize = Integer.valueOf(p1);

        ListView list = activity.findViewById(R.id.list);

        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        assertEquals(
            "El ListView debe tener " + expectedSize + " elementos",
            expectedSize, list.getCount()
        );
    }

    public void pulsarBotonMaster() {
        View master = activity.findViewById(R.id.master);
        master.performClick();
    }

    public void mostrarContadorEnListaEnPosicionP1ConValorP2(String p1, String p2) {

        int pos = Integer.valueOf(p1);
        int expectedValue = Integer.valueOf(p2);

        ListView list = activity.findViewById(R.id.list);

        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        CounterData item = (CounterData) list.getAdapter().getItem(pos);
        int value = item.value;

        assertEquals(
            "El contador en la posición "+ pos +" debe tener el valor "+ expectedValue,
            expectedValue, value
        );
    }

    public void mostrarContadorConValorP1(String p1) {

        String expected = p1;

        TextView counter = activity.findViewById(R.id.counter);

        assertEquals(
            "El texto del contador debe ser " + expected,
            expected, counter.getText().toString()
        );
    }

    public void mostrarNumeroDeClicksConValorP1(String p1) {

        String expected = p1;

        TextView clicks = activity.findViewById(R.id.clicks);

        assertEquals(
            "El número de clicks debe ser " + expected,
            expected, clicks.getText().toString()
        );
    }

    public void pulsarBotonContadorEnPosicionP1(String p1) {

        int pos = Integer.valueOf(p1);

        ListView list = activity.findViewById(R.id.list);

        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        View item = list.getChildAt(pos);

        if (item == null) {
            item = list.getAdapter().getView(pos, null, list);

            item.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            item.layout(0, 0, item.getMeasuredWidth(), item.getMeasuredHeight());
        }

        // Invocar el clic directamente en el ítem
        // para activar el listener asignado en el adaptador
        item.performClick();
        shadowOf(Looper.getMainLooper()).idle();
    }

    // Actualización: ya no se hace cast a Button, sino que se usa View,
    // pues el botón de detalle es un FloatingActionButton.
    public void pulsarBotonDetalle() {
        View detail = activity.findViewById(R.id.detail);
        detail.performClick();
        shadowOf(Looper.getMainLooper()).idle();
    }

    public void pulsarBotonRegresar() {
        activity.onBackPressed();
        shadowOf(Looper.getMainLooper()).idle();
    }

    public void pulsarBotonMasterNumeroDeVecesP1(String p1) {
        int times = Integer.valueOf(p1);
        for (int i = 0; i < times; i++) {
            pulsarBotonMaster();
            shadowOf(Looper.getMainLooper()).idle();
        }
    }

    public void pulsarBotonContadorEnPosicionP1NumeroDeVecesP2(String p1, String p2) {
        int times = Integer.valueOf(p2);
        for (int i = 0; i < times; i++) {
            pulsarBotonContadorEnPosicionP1(p1);
            shadowOf(Looper.getMainLooper()).idle();
            pulsarBotonRegresar();
        }
    }

    public void pulsarBotonDetalleNumeroDeVecesP1(String p1) {
        int times = Integer.valueOf(p1);
        for (int i = 0; i < times; i++) {
            pulsarBotonDetalle();
            shadowOf(Looper.getMainLooper()).idle();
        }
    }

    /**
     * Captura el Intent lanzado por MasterActivity, inicia DetailActivity y
     * devuelve un objeto de pasos para la pantalla de detalle.
     */
    public RobolectricTestsSteps obtenerDetailSteps() {
        Intent detailIntent = shadowOf(activity).getNextStartedActivity();
        DetailActivity detailActivity =
            Robolectric.buildActivity(DetailActivity.class, detailIntent).setup().get();
        return new RobolectricTestsSteps(detailActivity);
    }
}
