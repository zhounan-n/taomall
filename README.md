商品规格直接用json串保存
ftp搭建图片服务器(不推荐  此处练手)
内容管理：页面上的商品 广告位(链接(图片需要上传) 标题 属性 备注等公共属性)
-- 图片缓存(todo 内容管理 缓存同步)
httpclient调用服务

redis集群的搭建：
商品类目缓存:

在rest工程中发布一个服务，当后台管理系统修改内容后，调用此服务，同步缓存

为了提高响应速度，商品详情页面分布加载：(先查询缓存)
第一步：先展示商品基本信息，例如商品的名称、图片、价格
第二部：展示商品的描述，异步加载
第三部：商品规格



