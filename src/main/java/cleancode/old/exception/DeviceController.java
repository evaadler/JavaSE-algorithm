package cleancode.old.exception;

import com.sun.media.jfxmedia.logging.Logger;
import ningM.com.adobe.service.Deduplication;
import org.apache.logging.log4j.LogManager;

import java.awt.image.PixelGrabber;


/**
 * DeviceController
 * 使用异常而非返回码
 * 问题：搞乱了调用者代码。调用者必须在调用之后即刻检查错误
 * 好的做法是遇到错误时，最好抛出一个异常
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
        DeviceHandle handle = getHandle(DEV1);
        // check the state of the device
        if (handle != DeviceHandle.INVALID) {
            // save the device status to the record field
            retrieveDeviceRecord(handle);
            // if not suspended, shut down
            if (record.getStatus() != DEVICE_SUSPENDED) {
                pauseDevice(handle);
                clearDeviceWorkQueue(handle);
                closeDevice(handle);
            } else {
                logger.info("Device suspended. Unable to shutdown");
            }
        }else {
            logger.info("Invalid handle for: " + DEV1.toString());
        }
    }

    private DeviceHandle getHandle(Object obj) {
        return null;
    }

    private void closeDevice(DeviceHandle handle) { }

    private void clearDeviceWorkQueue(DeviceHandle handle) { }

    private void pauseDevice(DeviceHandle handle) { }

    private void retrieveDeviceRecord(DeviceHandle handle) { }
}
