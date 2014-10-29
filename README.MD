# Props2Json

props2json is a command line utility / library to convert java properties to json representation.

this is useful for config generationan and as simple properties to pojo maping.

support is there for nested structures and arrays.

## Example 

### Sample Properties file

```properties
a=123
b=abc
c=True
d.e=True
d.f=False
negativeNum=-1
positiveFloat=0.189
negativeFloat=-0.189
e.list=1,2,3,4,5,6,7,8,9,10
f.list=-1,2.1,-3.14,0,0.0,true,false,TRUE,FALSE,David
```

### Sample Json output

```javascript
{
  "b": "abc",
  "a": 123,
  "negativeFloat": -0.189,
  "negativeNum": -1,
  "d": {
    "f": false,
    "e": true
  },
  "e": {
    "list": [
      -1,
      2.1,
      -3.14,
      0,
      0.0,
      true,
      false,
      true,
      false,
      "David"
    ]
  },
  "c": true
}
```

Points to note are comma is indicator of dilemeter of array, dot character indicates nested javascipt , basic json types are detected.

## Usage

### Command Line

	#### File based 

  java -jar props2json-1.0-jar-with-dependencies.jar <  source.properties 


### Code Use

```java
import com.aahmedse.props2json.PropsToJsonUtil;
import java.util.Properties;

public class Sample {	
	
	public static void main(String args[]){
		
	Properties p = new Properties();
	
	 p.setProperty("a", "123");
	 p.setProperty("b", "abc");
	 p.setProperty("c", "True");
	 p.setProperty("d.e", "True");
	 p.setProperty("d.f", "False");
	 p.setProperty("negativeNum", "-1");
	 p.setProperty("negativeFloat", "-0.189");
	 p.setProperty("negativeFloat", "-0.189");
	 p.setProperty("e.list", "1,2,3,4,5,6,7,8,9,10");
	 p.setProperty("e.list", "-1,2.1,-3.14,0,0.0,true,false,TRUE,FALSE,David");
	 
	System.out.println(PropsToJsonUtil.convertToJson(p));
}

}
```


## Build Instructions

```
  mvn clean compile assembly:single

```

