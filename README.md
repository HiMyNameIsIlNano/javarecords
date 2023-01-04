# javarecords

This is just a simple repository for testing purposes. I just wanted to showcase how Pojo classes and records are handles differently
by the JVM when used to serialize and deserialize objects. 

The idea behind the test is pretty simple:

- `interval.invalid.pojo` contains an invalid serialized IntervalPojo (i.e. an interval such that `to < from`)
- `interval.invalid.record` contains an invalid serialized IntervalRecord (i.e. an interval such that `to < from`)

The `ÌntervalPojoTest` class tests that the deserialization of a wrong interval into a `IntervalPojo` is possible despite the constructor having a validation 
for the interval state (see [IntervalPojo](src/main/java/hi/mynameisilnano/javarecord/IntervalPojo.java)). In this case the JVM does not call the canonical constructor at all!

The `ÌntervalRecordTest` class tests that the deserialization of a wrong interval into a `IntervalRecord` is not possible as the JVM calls the canonical constructor
during the deserialization (see [IntervalRecord](src/main/java/hi/mynameisilnano/javarecord/IntervalRecord.java)).