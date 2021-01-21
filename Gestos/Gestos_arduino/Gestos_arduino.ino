#include "I2Cdev.h"
#include "MPU6050.h"
#include "Wire.h"

MPU6050 sensor;

int ax, ay, az;
int gx, gy, gz;

void setup(){
  Serial.begin(9600);
  Wire.begin();
  sensor.initialize();
  sensor.setXAccelOffset(-771);
  sensor.setYAccelOffset(2587);
  sensor.setZAccelOffset(1479);
  sensor.setXGyroOffset(36);
  sensor.setYGyroOffset(-80);
  sensor.setZGyroOffset(5);
}

void loop(){
  sensor.getAcceleration(&ax, &ay, &az);
  sensor.getRotation(&gx, &gy, &gz);
  Serial.print(ax); Serial.print(',');
  Serial.print(ay); Serial.print(',');
  Serial.print(az); Serial.print(',');
  Serial.print(gx); Serial.print(',');
  Serial.print(gy); Serial.print(',');
  Serial.print(gz); Serial.println();
}
