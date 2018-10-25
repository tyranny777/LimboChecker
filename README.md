# LimboChecker

#### implementation 'com.github.tyranny777:LimboChecker:96683d5fae'

```NonNullCondition noNull = new NonNullCondition(false);
ValidatePhoneCondition val = new ValidatePhoneCondition(11);
NonNullCondition noNull = new NonNullCondition();
LengthCondition len = new LengthCondition(11, ILimboChecker.LengthType.PHONE);

LimboMatchBody name = new LimboMatchBody("name","test");

LimboMatchBody phone = new LimboMatchBody("phone","12345678");

LinkedHashMap<BaseCondition, LimboMatchBody> map3 = new LinkedHashMap<>();
map3.put(noNull, name);

LinkedHashMap<BaseCondition, LimboMatchBody> map2 = new LinkedHashMap<>();
map2.put(noNull, phone);
map2.put(len, phone);
map2.put(val, phone);

LinkedHashMap<Object, LinkedHashMap<BaseCondition, LimboMatchBody>> mapHashMap = new LinkedHashMap<>();

mapHashMap.put(editText1, map3);
mapHashMap.put(editText2, map2);

OverAllUtil.checkAll(mapHashMap);
```
