# LimboChecker
```NonNullCondition noNull = new NonNullCondition(false);
ValidatePhoneCondition val = new ValidatePhoneCondition(11);
NonNullCondition noNull = new NonNullCondition();
LengthCondition len = new LengthCondition(11, IContentChecker.LengthType.PHONE);

ContentMatchBody name = new ContentMatchBody("name","test");

ContentMatchBody phone = new ContentMatchBody("phone","12345678");

LinkedHashMap<BaseCondition, ContentMatchBody> map3 = new LinkedHashMap<>();
map3.put(noNull, name);

LinkedHashMap<BaseCondition, ContentMatchBody> map2 = new LinkedHashMap<>();
map2.put(noNull, phone);
map2.put(len, phone);
map2.put(val, phone);

LinkedHashMap<Object, LinkedHashMap<BaseCondition, ContentMatchBody>> mapHashMap = new LinkedHashMap<>();

mapHashMap.put(editText1, map3);
mapHashMap.put(editText2, map2);

OverAllUtil.checkAll(mapHashMap);
```
