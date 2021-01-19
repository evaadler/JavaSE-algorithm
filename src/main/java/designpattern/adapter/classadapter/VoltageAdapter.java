package designpattern.adapter.classadapter;

/**
 * VoltageAdapter
 *
 * @author Alicia
 * @description
 * @date 2021/1/19
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V{

    @Override
    public int output5V() {
        int srcV = output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}
