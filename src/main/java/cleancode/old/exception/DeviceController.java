package cleancode.old.exception;

import org.apache.logging.log4j.LogManager;

import java.awt.image.PixelGrabber;


/**
 * DeviceController
 * 使用异常而非返回码（重构后）
 * 之前纠结的两个元素：【设备关闭算法】和【错误处理】现在被隔离了
 *
 * @author Alicia
 * @description
 * @date 2020/6/11
 */
public class DeviceController {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DeviceController.class);
    private static final Object DEV1 = null;
    private static final Object DEVICE_SUSPENDED = null;
    private PixelGrabber record;

    public void sendShutDown() {
        try {
            tryToShutDown();
        } catch (DeviceShutDownError e) {
            logger.info(e);
        }
    }

    private void tryToShutDown() throws DeviceShutDownError{
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle(DeviceID id) {

        // throw new DeviceShutDownError("Invalid handle for: " + id.toString());
        return null;
    }

    private DeviceHandle getHandle(Object obj) {
        return null;
    }

    private void closeDevice(DeviceHandle handle) { }

    private void clearDeviceWorkQueue(DeviceHandle handle) { }

    private void pauseDevice(DeviceHandle handle) { }

    private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) { return null;}
}
