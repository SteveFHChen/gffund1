if (!window.WD) {
	window.WD = {};
}

WD.Dict = {};

/**
 * 认证材料状态
 */
WD.Dict.MaterialStatus = [ {key:"UNAUTHERIZED", text:"未认证"}, {key:"APPLY", text:"已提交"}, {key:"PASS", text:"已通过"}, {key:"UNCLEAR", text:"不清晰"}, {key:"UNLEGAL", text:"格式不对"}, {key:"FAKE", text:"作假"}, {key:"UNNEEDVERIFY", text:"无需审核"} ];
/**
 * 性别
 */
WD.Dict.Sex = [ {key:"MALE", text:"男"}, {key:"FEMALE", text:"女"}, {key:"UNKNOWN", text:"未知"} ];

/**
 * 借款申请类型
 */
WD.Dict.LoanType = [ {key:"", text:"不限"}, {key:"CREDIT", text:"信用贷"}, {key:"OPERATE", text:"经营贷"} ];

/**
 * 证件类型
 */
WD.Dict.CertType = [ {key:"IDENTCARD", text:"身份证"} ];

/**
 * 学历
 */
WD.Dict.Education = [ {key:"MASTER", text:"硕士"} ];

WD.Dict.Province = [
    {key:"北京", text:"北京"},
    {key:"天津", text:"天津"},
    {key:"河北", text:"河北"},
    {key:"山西", text:"山西"},
    {key:"辽宁", text:"辽宁"},
    {key:"吉林", text:"吉林"},
    {key:"上海", text:"上海"},
    {key:"江苏", text:"江苏"},
    {key:"浙江", text:"浙江"},
    {key:"安徽", text:"安徽"},
    {key:"福建", text:"福建"},
    {key:"江西", text:"江西"},
    {key:"山东", text:"山东"},
    {key:"河南", text:"河南"},
    {key:"内蒙古", text:"内蒙古"},
	{key:"黑龙江", text:"黑龙江"},
	{key:"湖北", text:"湖北"},
	{key:"湖南", text:"湖南"},
	{key:"广东", text:"广东"},
	{key:"广西", text:"广西"},
	{key:"海南", text:"海南"},
	{key:"四川", text:"四川"},
	{key:"重庆", text:"重庆"},
	{key:"台湾", text:"台湾"},
	{key:"贵州", text:"贵州"},
	{key:"云南", text:"云南"},
	{key:"西藏", text:"西藏"},
	{key:"陕西", text:"陕西"},
	{key:"甘肃", text:"甘肃"},
	{key:"青海", text:"青海"},
	{key:"宁夏", text:"宁夏"},
	{key:"新疆", text:"新疆"},
	{key:"香港", text:"香港"},
	{key:"澳门", text:"澳门"}
];

WD.Dict.City = {
	"北京": [{key:"东城区", text:"东城区"},{key:"西城区", text:"西城区"},{key:"崇文区", text:"崇文区"},{key:"宣武区", text:"宣武区"},{key:"朝阳区", text:"朝阳区"},{key:"丰台区", text:"丰台区"},{key:"石景山区", text:"石景山区"},{key:"海淀区", text:"海淀区"},{key:"门头沟区", text:"门头沟区"},{key:"房山区", text:"房山区"},{key:"通州区", text:"通州区"},{key:"顺义区", text:"顺义区"},{key:"延庆县", text:"延庆县"},{key:"昌平区", text:"昌平区"},{key:"怀柔区", text:"怀柔区"},{key:"密云县", text:"密云县"},{key:"平谷区", text:"平谷区"},{key:"大兴区", text:"大兴区"},{key:"其他", text:"其他"}],
	"天津": [{key:"和平区", text:"和平区"},{key:"河东区", text:"河东区"},{key:"河西区", text:"河西区"},{key:"南开区", text:"南开区"},{key:"河北区", text:"河北区"},{key:"红桥区", text:"红桥区"},{key:"塘沽区", text:"塘沽区"},{key:"大港区", text:"大港区"},{key:"东丽区", text:"东丽区"},{key:"西青区", text:"西青区"},{key:"津南区", text:"津南区"},{key:"北辰区", text:"北辰区"},{key:"蓟县", text:"蓟县"},{key:"宝坻区", text:"宝坻区"},{key:"武清区", text:"武清区"},{key:"宁河县", text:"宁河县"},{key:"静海县", text:"静海县"},{key:"汉沽区", text:"汉沽区"},{key:"其他", text:"其他"}],
	"河北": [{key:"石家庄市", text:"石家庄市"},{key:"张家口市", text:"张家口市"},{key:"承德市", text:"承德市"},{key:"秦皇岛市", text:"秦皇岛市"},{key:"唐山市", text:"唐山市"},{key:"廊坊市", text:"廊坊市"},{key:"保定市", text:"保定市"},{key:"沧州市", text:"沧州市"},{key:"衡水市", text:"衡水市"},{key:"邢台市", text:"邢台市"},{key:"邯郸市", text:"邯郸市"}],
	"山西": [{key:"太原市", text:"太原市"},{key:"大同市", text:"大同市"},{key:"朔州市", text:"朔州市"},{key:"阳泉市", text:"阳泉市"},{key:"长治市", text:"长治市"},{key:"晋城市", text:"晋城市"},{key:"忻州市", text:"忻州市"},{key:"吕梁市", text:"吕梁市"},{key:"晋中市", text:"晋中市"},{key:"临汾市", text:"临汾市"},{key:"运城市", text:"运城市"}],
	"辽宁": [{key:"沈阳市", text:"沈阳市"},{key:"朝阳市", text:"朝阳市"},{key:"阜新市", text:"阜新市"},{key:"铁岭市", text:"铁岭市"},{key:"抚顺市", text:"抚顺市"},{key:"本溪市", text:"本溪市"},{key:"辽阳市", text:"辽阳市"},{key:"鞍山市", text:"鞍山市"},{key:"丹东市", text:"丹东市"},{key:"大连市", text:"大连市"},{key:"营口市", text:"营口市"},{key:"盘锦市", text:"盘锦市"},{key:"锦州市", text:"锦州市"},{key:"葫芦岛市", text:"葫芦岛市"}],
	"吉林": [{key:"长春市", text:"长春市"},{key:"白城市", text:"白城市"},{key:"松原市", text:"松原市"},{key:"吉林市", text:"吉林市"},{key:"四平市", text:"四平市"},{key:"辽源市", text:"辽源市"},{key:"通化市", text:"通化市"},{key:"白山市", text:"白山市"},{key:"延边朝鲜族自治州", text:"延边朝鲜族自治州"}],
	"上海": [{key:"其他", text:"其他"},{key:"黄浦区", text:"黄浦区"},{key:"卢湾区", text:"卢湾区"},{key:"徐汇区", text:"徐汇区"},{key:"长宁区", text:"长宁区"},{key:"静安区", text:"静安区"},{key:"普陀区", text:"普陀区"},{key:"闸北区", text:"闸北区"},{key:"虹口区", text:"虹口区"},{key:"杨浦区", text:"杨浦区"},{key:"闵行区", text:"闵行区"},{key:"宝山区", text:"宝山区"},{key:"嘉定区", text:"嘉定区"},{key:"浦东新区", text:"浦东新区"},{key:"金山区", text:"金山区"},{key:"松江区", text:"松江区"},{key:"崇明县", text:"崇明县"},{key:"青浦区", text:"青浦区"},{key:"南汇区", text:"南汇区"},{key:"奉贤区", text:"奉贤区"}],
	"江苏": [{key:"南京市", text:"南京市"},{key:"徐州市", text:"徐州市"},{key:"连云港市", text:"连云港市"},{key:"宿迁市", text:"宿迁市"},{key:"淮安市", text:"淮安市"},{key:"盐城市", text:"盐城市"},{key:"扬州市", text:"扬州市"},{key:"泰州市", text:"泰州市"},{key:"南通市", text:"南通市"},{key:"镇江市", text:"镇江市"},{key:"常州市", text:"常州市"},{key:"无锡市", text:"无锡市"},{key:"苏州市", text:"苏州市"}],
	"浙江": [{key:"杭州市", text:"杭州市"},{key:"湖州市", text:"湖州市"},{key:"嘉兴市", text:"嘉兴市"},{key:"舟山市", text:"舟山市"},{key:"宁波市", text:"宁波市"},{key:"绍兴市", text:"绍兴市"},{key:"金华市", text:"金华市"},{key:"台州市", text:"台州市"},{key:"温州市", text:"温州市"},{key:"丽水市", text:"丽水市"},{key:"衢州市", text:"衢州市"}],
	"安徽": [{key:"合肥市", text:"合肥市"},{key:"宿州市", text:"宿州市"},{key:"淮北市", text:"淮北市"},{key:"阜阳市", text:"阜阳市"},{key:"蚌埠市", text:"蚌埠市"},{key:"淮南市", text:"淮南市"},{key:"滁州市", text:"滁州市"},{key:"马鞍山市", text:"马鞍山市"},{key:"芜湖市", text:"芜湖市"},{key:"铜陵市", text:"铜陵市"},{key:"安庆市", text:"安庆市"},{key:"黄山市", text:"黄山市"},{key:"六安市", text:"六安市"},{key:"巢湖市", text:"巢湖市"},{key:"池州市", text:"池州市"},{key:"宣城市", text:"宣城市"},{key:"亳州市", text:"亳州市"}],
	"福建": [{key:"福州市", text:"福州市"},{key:"南平市", text:"南平市"},{key:"三明市", text:"三明市"},{key:"莆田市", text:"莆田市"},{key:"泉州市", text:"泉州市"},{key:"厦门市", text:"厦门市"},{key:"漳州市", text:"漳州市"},{key:"龙岩市", text:"龙岩市"},{key:"宁德市", text:"宁德市"}],
	"江西": [{key:"南昌市", text:"南昌市"},{key:"九江市", text:"九江市"},{key:"景德镇市", text:"景德镇市"},{key:"鹰潭市", text:"鹰潭市"},{key:"新余市", text:"新余市"},{key:"萍乡市", text:"萍乡市"},{key:"赣州市", text:"赣州市"},{key:"上饶市", text:"上饶市"},{key:"抚州市", text:"抚州市"},{key:"宜春市", text:"宜春市"},{key:"吉安市", text:"吉安市"}],
	"山东": [{key:"济南市", text:"济南市"},{key:"聊城市", text:"聊城市"},{key:"德州市", text:"德州市"},{key:"东营市", text:"东营市"},{key:"淄博市", text:"淄博市"},{key:"潍坊市", text:"潍坊市"},{key:"烟台市", text:"烟台市"},{key:"威海市", text:"威海市"},{key:"青岛市", text:"青岛市"},{key:"日照市", text:"日照市"},{key:"临沂市", text:"临沂市"},{key:"枣庄市", text:"枣庄市"},{key:"济宁市", text:"济宁市"},{key:"泰安市", text:"泰安市"},{key:"莱芜市", text:"莱芜市"},{key:"滨州市", text:"滨州市"},{key:"菏泽市", text:"菏泽市"}],
	"河南": [{key:"郑州市", text:"郑州市"},{key:"三门峡市", text:"三门峡市"},{key:"洛阳市", text:"洛阳市"},{key:"焦作市", text:"焦作市"},{key:"新乡市", text:"新乡市"},{key:"鹤壁市", text:"鹤壁市"},{key:"安阳市", text:"安阳市"},{key:"濮阳市", text:"濮阳市"},{key:"开封市", text:"开封市"},{key:"商丘市", text:"商丘市"},{key:"许昌市", text:"许昌市"},{key:"漯河市", text:"漯河市"},{key:"平顶山市", text:"平顶山市"},{key:"南阳市", text:"南阳市"},{key:"信阳市", text:"信阳市"},{key:"济源市", text:"济源市"},{key:"周口市", text:"周口市"},{key:"驻马店市", text:"驻马店市"}],
	"内蒙古": [{key:"呼和浩特市", text:"呼和浩特市"},{key:"包头市", text:"包头市"},{key:"乌海市", text:"乌海市"},{key:"赤峰市", text:"赤峰市"},{key:"呼伦贝尔", text:"呼伦贝尔"},{key:"兴安盟", text:"兴安盟"},{key:"锡林郭勒盟", text:"锡林郭勒盟"},{key:"乌兰察布市", text:"乌兰察布市"},{key:"巴彦淖尔市", text:"巴彦淖尔市"},{key:"阿拉善盟", text:"阿拉善盟"},{key:"鄂尔多斯市", text:"鄂尔多斯市"},{key:"通辽市", text:"通辽市"}],
	"黑龙江": [{key:"哈尔滨市", text:"哈尔滨市"},{key:"齐齐哈尔市", text:"齐齐哈尔市"},{key:"黑河市", text:"黑河市"},{key:"大庆市", text:"大庆市"},{key:"伊春市", text:"伊春市"},{key:"鹤岗市", text:"鹤岗市"},{key:"佳木斯市", text:"佳木斯市"},{key:"双鸭山市", text:"双鸭山市"},{key:"七台河市", text:"七台河市"},{key:"鸡西市", text:"鸡西市"},{key:"牡丹江市", text:"牡丹江市"},{key:"绥化地区", text:"绥化地区"},{key:"大兴安岭地区", text:"大兴安岭地区"}],
	"湖北": [{key:"武汉市", text:"武汉市"},{key:"十堰市", text:"十堰市"},{key:"襄樊市", text:"襄樊市"},{key:"荆门市", text:"荆门市"},{key:"孝感市", text:"孝感市"},{key:"黄冈市", text:"黄冈市"},{key:"鄂州市", text:"鄂州市"},{key:"黄石市", text:"黄石市"},{key:"咸宁市", text:"咸宁市"},{key:"荆州市", text:"荆州市"},{key:"宜昌市", text:"宜昌市"},{key:"随州市", text:"随州市"},{key:"仙桃市", text:"仙桃市"},{key:"天门市", text:"天门市"},{key:"潜江市", text:"潜江市"},{key:"神农架林区", text:"神农架林区"},{key:"恩施土家族苗族自治州", text:"恩施土家族苗族自治州"}],
	"湖南": [{key:"长沙市", text:"长沙市"},{key:"张家界市", text:"张家界市"},{key:"常德市", text:"常德市"},{key:"益阳市", text:"益阳市"},{key:"岳阳市", text:"岳阳市"},{key:"株洲市", text:"株洲市"},{key:"湘潭市", text:"湘潭市"},{key:"衡阳市", text:"衡阳市"},{key:"郴州市", text:"郴州市"},{key:"永州市", text:"永州市"},{key:"邵阳市", text:"邵阳市"},{key:"怀化市", text:"怀化市"},{key:"娄底市", text:"娄底市"},{key:"湘西土家族苗族自治州", text:"湘西土家族苗族自治州"}],
	"广东": [{key:"广州市", text:"广州市"},{key:"清远市", text:"清远市"},{key:"韶关市", text:"韶关市"},{key:"河源市", text:"河源市"},{key:"梅州市", text:"梅州市"},{key:"潮州市", text:"潮州市"},{key:"汕头市", text:"汕头市"},{key:"揭阳市", text:"揭阳市"},{key:"汕尾市", text:"汕尾市"},{key:"惠州市", text:"惠州市"},{key:"东莞市", text:"东莞市"},{key:"深圳市", text:"深圳市"},{key:"珠海市", text:"珠海市"},{key:"中山市", text:"中山市"},{key:"江门市", text:"江门市"},{key:"佛山市", text:"佛山市"},{key:"肇庆市", text:"肇庆市"},{key:"云浮市", text:"云浮市"},{key:"阳江市", text:"阳江市"},{key:"茂名市", text:"茂名市"},{key:"湛江市", text:"湛江市"}],
	"广西": [{key:"南宁市", text:"南宁市"},{key:"桂林市", text:"桂林市"},{key:"柳州市", text:"柳州市"},{key:"梧州市", text:"梧州市"},{key:"贵港市", text:"贵港市"},{key:"玉林市", text:"玉林市"},{key:"钦州市", text:"钦州市"},{key:"北海市", text:"北海市"},{key:"防城港市", text:"防城港市"},{key:"百色市", text:"百色市"},{key:"河池市", text:"河池市"},{key:"贺州市", text:"贺州市"},{key:"崇左市", text:"崇左市"},{key:"凭祥市", text:"凭祥市"},{key:"来宾市", text:"来宾市"}],
	"海南": [{key:"海口市", text:"海口市"},{key:"三亚市", text:"三亚市"},{key:"琼山市", text:"琼山市"},{key:"文昌市", text:"文昌市"},{key:"琼海市", text:"琼海市"},{key:"万宁市", text:"万宁市"},{key:"东方市", text:"东方市"},{key:"儋州市", text:"儋州市"},{key:"临高县", text:"临高县"},{key:"澄迈县", text:"澄迈县"},{key:"定安县", text:"定安县"},{key:"屯昌县", text:"屯昌县"},{key:"昌江黎族自治县", text:"昌江黎族自治县"},{key:"白沙黎族自治县", text:"白沙黎族自治县"},{key:"琼中黎族苗族自治县", text:"琼中黎族苗族自治县"},{key:"陵水黎族自治县", text:"陵水黎族自治县"},{key:"保亭黎族苗族自治县", text:"保亭黎族苗族自治县"},{key:"乐东黎族自治县", text:"乐东黎族自治县"},{key:"五指山市", text:"五指山市"}],
	"四川": [{key:"成都市", text:"成都市"},{key:"广元市", text:"广元市"},{key:"绵阳市", text:"绵阳市"},{key:"德阳市", text:"德阳市"},{key:"南充市", text:"南充市"},{key:"广安市", text:"广安市"},{key:"遂宁市", text:"遂宁市"},{key:"内江市", text:"内江市"},{key:"乐山市", text:"乐山市"},{key:"自贡市", text:"自贡市"},{key:"泸州市", text:"泸州市"},{key:"宜宾市", text:"宜宾市"},{key:"攀枝花市", text:"攀枝花市"},{key:"巴中市", text:"巴中市"},{key:"达州市", text:"达州市"},{key:"资阳市", text:"资阳市"},{key:"眉山市", text:"眉山市"},{key:"雅安市", text:"雅安市"},{key:"阿坝藏族羌族自治州", text:"阿坝藏族羌族自治州"},{key:"甘孜藏族自治州", text:"甘孜藏族自治州"},{key:"凉山彝族自治州", text:"凉山彝族自治州"}],
	"重庆": [{key:"其他", text:"其他"},{key:"渝中区", text:"渝中区"},{key:"大渡口区", text:"大渡口区"},{key:"江北区", text:"江北区"},{key:"沙坪坝区", text:"沙坪坝区"},{key:"九龙坡区", text:"九龙坡区"},{key:"南岸区", text:"南岸区"},{key:"北碚区", text:"北碚区"},{key:"万盛区", text:"万盛区"},{key:"双桥区", text:"双桥区"},{key:"渝北区", text:"渝北区"},{key:"巴南区", text:"巴南区"},{key:"万州区", text:"万州区"},{key:"涪陵区", text:"涪陵区"},{key:"合川市", text:"合川市"},{key:"永川市", text:"永川市"},{key:"江津市", text:"江津市"},{key:"南川市", text:"南川市"},{key:"长寿区", text:"长寿区"},{key:"綦江县", text:"綦江县"},{key:"潼南县", text:"潼南县"},{key:"铜梁县", text:"铜梁县"},{key:"大足县", text:"大足县"},{key:"荣昌县", text:"荣昌县"},{key:"璧山县", text:"璧山县"},{key:"垫江县", text:"垫江县"},{key:"武隆县", text:"武隆县"},{key:"丰都县", text:"丰都县"},{key:"城口县", text:"城口县"},{key:"梁平县", text:"梁平县"},{key:"黔江区", text:"黔江区"},{key:"奉节县", text:"奉节县"},{key:"开县", text:"开县"},{key:"云阳县", text:"云阳县"},{key:"忠县", text:"忠县"},{key:"巫溪县", text:"巫溪县"},{key:"巫山县", text:"巫山县"},{key:"石柱土家族自治县", text:"石柱土家族自治县"},{key:"秀山土家族苗族自治县", text:"秀山土家族苗族自治县"},{key:"酉阳土家族苗族自治县", text:"酉阳土家族苗族自治县"},{key:"彭水苗族土家族自治县", text:"彭水苗族土家族自治县"}],
	"台湾": [{key:"台北市", text:"台北市"},{key:"高雄市", text:"高雄市"},{key:"台南市", text:"台南市"},{key:"台中市", text:"台中市"},{key:"基隆市", text:"基隆市"},{key:"新竹市", text:"新竹市"},{key:"嘉义市", text:"嘉义市"},{key:"台北县", text:"台北县"},{key:"宜兰县", text:"宜兰县"},{key:"新竹县", text:"新竹县"},{key:"桃园县", text:"桃园县"},{key:"苗栗县", text:"苗栗县"},{key:"台中县", text:"台中县"},{key:"彰化县", text:"彰化县"},{key:"南投县", text:"南投县"},{key:"嘉义县", text:"嘉义县"},{key:"云林县", text:"云林县"},{key:"台南县", text:"台南县"},{key:"高雄县", text:"高雄县"},{key:"屏东县", text:"屏东县"},{key:"台东县", text:"台东县"},{key:"花莲县", text:"花莲县"},{key:"澎湖县", text:"澎湖县"},{key:"钓鱼岛", text:"钓鱼岛"}],
	"贵州": [{key:"贵阳市", text:"贵阳市"},{key:"六盘水市", text:"六盘水市"},{key:"遵义市", text:"遵义市"},{key:"毕节地区", text:"毕节地区"},{key:"铜仁地区", text:"铜仁地区"},{key:"安顺市", text:"安顺市"},{key:"黔东南苗族侗族自治州", text:"黔东南苗族侗族自治州"},{key:"黔南布依族苗族自治州", text:"黔南布依族苗族自治州"},{key:"黔西南布依族苗族自治州", text:"黔西南布依族苗族自治州"}],
	"云南": [{key:"昆明市", text:"昆明市"},{key:"曲靖市", text:"曲靖市"},{key:"玉溪市", text:"玉溪市"},{key:"丽江市", text:"丽江市"},{key:"昭通市", text:"昭通市"},{key:"普洱市", text:"普洱市"},{key:"临沧市", text:"临沧市"},{key:"保山市", text:"保山市"},{key:"德宏傣族景颇族自治州", text:"德宏傣族景颇族自治州"},{key:"怒江傈傈族自治州", text:"怒江傈傈族自治州"},{key:"迪庆藏族自治州", text:"迪庆藏族自治州"},{key:"大理白族自治州", text:"大理白族自治州"},{key:"楚雄彝族自治州", text:"楚雄彝族自治州"},{key:"红河哈尼族彝族自治州", text:"红河哈尼族彝族自治州"},{key:"文山壮族苗族自治州", text:"文山壮族苗族自治州"},{key:"西双版纳傣族自治州", text:"西双版纳傣族自治州"}],
	"西藏": [{key:"拉萨市", text:"拉萨市"},{key:"那曲地区", text:"那曲地区"},{key:"昌都地区", text:"昌都地区"},{key:"林芝地区", text:"林芝地区"},{key:"山南地区", text:"山南地区"},{key:"日喀则地区", text:"日喀则地区"},{key:"阿里地区", text:"阿里地区"}],
	"陕西": [{key:"西安市", text:"西安市"},{key:"延安市", text:"延安市"},{key:"铜川市", text:"铜川市"},{key:"渭南市", text:"渭南市"},{key:"咸阳市", text:"咸阳市"},{key:"宝鸡市", text:"宝鸡市"},{key:"汉中市", text:"汉中市"},{key:"榆林市", text:"榆林市"},{key:"商洛市", text:"商洛市"},{key:"安康市", text:"安康市"}],
	"甘肃": [{key:"兰州市", text:"兰州市"},{key:"嘉峪关市", text:"嘉峪关市"},{key:"金昌市", text:"金昌市"},{key:"白银市", text:"白银市"},{key:"天水市", text:"天水市"},{key:"酒泉市", text:"酒泉市"},{key:"张掖市", text:"张掖市"},{key:"武威市", text:"武威市"},{key:"庆阳市", text:"庆阳市"},{key:"平凉市", text:"平凉市"},{key:"定西市", text:"定西市"},{key:"陇南地区", text:"陇南地区"},{key:"临夏回族自治州", text:"临夏回族自治州"},{key:"甘南藏族自治州", text:"甘南藏族自治州"},{key:"玉门市", text:"玉门市"},{key:"敦煌市", text:"敦煌市"}],
	"青海": [{key:"西宁市", text:"西宁市"},{key:"海东地区", text:"海东地区"},{key:"海北藏族自治州", text:"海北藏族自治州"},{key:"海南藏族自治州", text:"海南藏族自治州"},{key:"黄南藏族自治州", text:"黄南藏族自治州"},{key:"果洛藏族自治州", text:"果洛藏族自治州"},{key:"玉树藏族自治州", text:"玉树藏族自治州"},{key:"海西蒙古族藏族自治州", text:"海西蒙古族藏族自治州"},{key:"青海省其它地区", text:"青海省其它地区"}],
	"宁夏": [{key:"银川市", text:"银川市"},{key:"石嘴山市", text:"石嘴山市"},{key:"吴忠市", text:"吴忠市"},{key:"固原市", text:"固原市"},{key:"中卫市", text:"中卫市"}],
	"新疆": [{key:"乌鲁木齐市", text:"乌鲁木齐市"},{key:"克拉玛依市", text:"克拉玛依市"},{key:"石河子市", text:"石河子市"},{key:"喀什地区", text:"喀什地区"},{key:"阿克苏地区", text:"阿克苏地区"},{key:"和田地区", text:"和田地区"},{key:"吐鲁番地区", text:"吐鲁番地区"},{key:"哈密地区", text:"哈密地区"},{key:"克孜勒苏柯尔克孜自治州", text:"克孜勒苏柯尔克孜自治州"},{key:"博尔塔拉蒙古自治州", text:"博尔塔拉蒙古自治州"},{key:"昌吉回族自治州", text:"昌吉回族自治州"},{key:"巴音郭楞蒙古自治州", text:"巴音郭楞蒙古自治州"},{key:"伊犁哈萨克自治州", text:"伊犁哈萨克自治州"},{key:"阿拉尔市", text:"阿拉尔市"},{key:"塔城地区", text:"塔城地区"},{key:"阿勒泰地区", text:"阿勒泰地区"},{key:"图木舒克市", text:"图木舒克市"},{key:"五家渠市", text:"五家渠市"}],
	"香港": [{key:"其他", text:"其他"},{key:"九龙城区", text:"九龙城区"},{key:"中西区", text:"中西区"},{key:"东区", text:"东区"},{key:"观塘区", text:"观塘区"},{key:"南区", text:"南区"},{key:"深水埗区", text:"深水埗区"},{key:"黄大仙区", text:"黄大仙区"},{key:"湾仔区", text:"湾仔区"},{key:"油尖旺区", text:"油尖旺区"},{key:"离岛区", text:"离岛区"},{key:"葵青区", text:"葵青区"},{key:"北区", text:"北区"},{key:"西贡区", text:"西贡区"},{key:"沙田区", text:"沙田区"},{key:"屯门区", text:"屯门区"},{key:"大埔区", text:"大埔区"},{key:"荃湾区", text:"荃湾区"},{key:"元朗区", text:"元朗区"}],
	"澳门": [{key:"其他", text:"其他"},{key:"花地玛堂区", text:"花地玛堂区"}, {key:"圣安多尼堂区", text:"圣安多尼堂区"}, {key:"大堂区", text:"大堂区"}, {key:"望德堂区", text:"望德堂区"}, {key:"风顺堂区", text:"风顺堂区"}, {key:"嘉模堂区", text:"嘉模堂区"}, {key:"圣方济各堂区", text:"圣方济各堂区"}]
};

WD.Dict.getDisplay = function(dictName, value, value2) {
	var dict = WD.Dict[dictName];
	if (dict) {
		if (value2) {
			dict = dict[value2];
		}
		if (dict) {
			for (var i=0, s=dict.length; i<s; i++) {
				if (dict[i].key == value) {
					return dict[i].text;
				}
			}
		}
	}
	return value;
};
