# LimboChecker
```NonNullCondition noNull = new NonNullCondition(false);
ContentMatchBody name = new ContentMatchBody("name",editText1.getText().toString().trim());

ContentMatchBody IDcard = new ContentMatchBody("idcard",editText2.getText().toString().trim());

LinkedHashMap<TextInputLayout, LinkedHashMap<BaseCondition, ContentMatchBody>> mapHashMap = new LinkedHashMap<>();

LinkedHashMap<BaseCondition, ContentMatchBody> map3 = new LinkedHashMap<>();
map3.put(noNull, name);

LinkedHashMap<BaseCondition, ContentMatchBody> map2 = new LinkedHashMap<>();
map2.put(noNull, IDcard);

mapHashMap.put(editText1, map3);
mapHashMap.put(editText2, map2);

OverAllUtil.checkAll(mapHashMap);
```
