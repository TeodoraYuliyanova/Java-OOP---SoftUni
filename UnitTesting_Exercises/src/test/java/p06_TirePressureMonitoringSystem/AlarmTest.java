package p06_TirePressureMonitoringSystem;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {


    @Test
    public void testCheckWithNormalPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithHighPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckWithLowPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(10.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }


}