package designpattern.adapter.classadapter;

/**
 * VoltageAdapter
 *
 * @author Alicia
 * @description
 * @date 2021/1/19
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V{

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (voltage220V != null) {
            int srcV = voltage220V.output220V();
            System.out.println("使用对象适配器啦，进行适配~~");
            dstV = srcV / 44;
            System.out.println("适配完成，输出的电压为="+dstV);
        }
        return dstV;
    }
}
