<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0046)http://localhost:8080/Voids/user/userUpdate.do -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!--<base href="http://localhost:8080/Voids/">-->
<base href=".">
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no">

<meta name="renderer" content="webkit">
<meta name="keywords"
	content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description"
	content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
<link rel="stylesheet" href="/VideoSSM/static/z/base.css">
<link rel="stylesheet" href="/VideoSSM/static/z/profile.css">
<link rel="icon"
	href="http://localhost:8080/VideoSSM/static/z/favicon.png"
	type="image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">




	<header>
	<div class="container top_bar clearfix">
		<img src="/VideoSSM/static/z/logo.png" alt="智游">
		<div id="tele">
			<span>4006-371-555</span> <span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="/VideoSSM/index.jsp">首页</a></li>

				<li class="menu_active"><a href="/VideoSSM/foreground/PersonalCenter.jsp">个人中心</a></li>
			</ul>

			<div id="user_bar">
				<a> <img id="avatar" src="${user.imgurl}" alt="""="">




				</a> <a href="/VideoSSM/loginOut.do">退出</a>
			</div>
		</div>
	</menu>
	</header>

	<main>
	<div class="container">
		<h2>我的资料</h2>
		<div id="profile_tab">
			<ul class="profile_tab_header f_left clearfix">
				<li><a href="/VideoSSM/userUpadteShow.do">更改资料</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="/VideoSSM/foreground/AvatarUpload.jsp">更改头像</a></li>
				<li class="profile_tab_line">|</li>
				<li><a href="/VideoSSM/foreground/PasswordUpdate.jsp">密码安全</a></li>
			</ul>
			<div class="proflle_tab_body">
				<div class="proflle_tab_workplace clearfix">
					<div class="profile_avatar_area">

						<img src="${user.imgurl}" width="200px;">



					</div>
					<div class="profile_ifo_area">
						<form action="/VideoSSM/userUpadte.do">
							<input name="id" value="${user.id}" type="hidden">
							<div class="form_group">
								<span class="dd">昵 称：</span><input name="nickname" type="text"
									value="${user.nickname}">

							</div>
							<div class="form_group">
								<span class="dd">性 别：</span> 
								<input id="man" type="radio" name="sex" value="man"><label
									for="man">男</label> 
							    <input id="woman" type="radio" name="sex" value="woman"><label
									for="woman">女</label>



							</div>
							<div class="form_group">
								<span class="dd">生 日：</span>
								<!-- 1990-10-04 -->
								<input name="birthday" type="text" value="${user.birthday}">
							</div>
							<div class="form_group">
								<span class="dd">邮 箱：</span> <span>${user.accounts}</span>
								<input name="accounts" value="${user.accounts}" type="hidden">
							</div>
							<div class="form_group">
								<span class="dd">所在地：</span>
								<div id="city">
									<select class="prov" name="prov" id="prov" >
										<option value="北京" 										
										<c:if test="${prov eq '北京'}">selected</c:if>
										>北京</option>
										<option value="天津"
										<c:if test="${prov eq '天津'}">selected</c:if>
										>天津</option>
										<option value="河北"
										<c:if test="${prov eq '河北'}">selected</c:if>
										>河北</option> 
										<option value="山西"
										<c:if test="${prov eq '山西'}">selected</c:if>
										>山西</option>
										<option value="内蒙古"
										<c:if test="${prov eq '内蒙古'}">selected</c:if>
										>内蒙古</option>
										<option value="辽宁"
										<c:if test="${prov eq '辽宁'}">selected</c:if>
										>辽宁</option>
										<option value="吉林"
										<c:if test="${prov eq '吉林'}">selected</c:if>
										>吉林</option>
										<option value="黑龙江"
										<c:if test="${prov eq '黑龙江'}">selected</c:if>
										>黑龙江</option>
										<option value="上海"
										<c:if test="${prov eq '上海'}">selected</c:if>
										>上海</option>
										<option value="江苏"
										<c:if test="${prov eq '江苏'}">selected</c:if>
										>江苏</option>
										<option value="浙江"
										<c:if test="${prov eq '浙江'}">selected</c:if>
										>浙江</option>
										<option value="安徽"
										<c:if test="${prov eq '安徽'}">selected</c:if>
										>安徽</option>
										<option value="福建"
										<c:if test="${prov eq '福建'}">selected</c:if>
										>福建</option>
										<option value="江西"
										<c:if test="${prov eq '江西'}">selected</c:if>
										>江西</option>
										<option value="山东"
										<c:if test="${prov eq '山东'}">selected</c:if>
										>山东</option>
										<option value="河南" 
										<c:if test="${prov eq '河南'}">selected</c:if>
										>河南</option>
										<option value="湖北"
										<c:if test="${prov eq '湖北'}">selected</c:if>
										>湖北</option>
										<option value="湖南"
										<c:if test="${prov eq '湖南'}">selected</c:if>
										>湖南</option>
										<option value="广东"
										<c:if test="${prov eq '广东'}">selected</c:if>
										>广东</option>
										<option value="广西"
										<c:if test="${prov eq '广西'}">selected</c:if>
										>广西</option>
										<option value="海南"
										<c:if test="${prov eq '海南'}">selected</c:if>
										>海南</option>
										<option value="重庆"
										<c:if test="${prov eq '重庆'}">selected</c:if>
										>重庆</option>
										<option value="四川"
										<c:if test="${prov eq '四川'}">selected</c:if>
										>四川</option>
										<option value="贵州"
										<c:if test="${prov eq '贵州'}">selected</c:if>
										>贵州</option>
										<option value="云南"
										<c:if test="${prov eq '云南'}">selected</c:if>
										>云南</option>
										<option value="西藏"
										<c:if test="${prov eq '西藏'}">selected</c:if>
										>西藏</option>
										<option value="陕西"
										<c:if test="${prov eq '陕西'}">selected</c:if>
										>陕西</option>
										<option value="甘肃"
										<c:if test="${prov eq '甘肃'}">selected</c:if>
										>甘肃</option>
										<option value="青海"
										<c:if test="${prov eq '青海'}">selected</c:if>
										>青海</option>
										<option value="宁夏"
										<c:if test="${prov eq '宁夏'}">selected</c:if>
										>宁夏</option>
										<option value="新疆"
										<c:if test="${prov eq '新疆'}">selected</c:if>
										>新疆</option>
										<option value="香港"
										<c:if test="${prov eq '香港'}">selected</c:if>
										>香港</option>
										<option value="澳门"
										<c:if test="${prov eq '澳门'}">selected</c:if>
										>澳门</option>
										<option value="台湾"
										<c:if test="${prov eq '台湾'}">selected</c:if>
										>台湾</option>
										<option value="国外"
										<c:if test="${prov eq '国外'}">selected</c:if>
										>国外</option>
									</select> 
									<select class="city" name="city" id="citySelectOption">
									<option value="-1">请选择</option>
									</select>
								</div>
								<input name="address" id="address" type="hidden">
							</div>
							<div class="form_submit dd">
								<input onclick="return commitForm();" value="保　存" type="submit">
								<a href="/VideoSSM/foreground/UserUpdate.jsp">重置</a>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>



	<footer>
	<div class="container">
		<ul>
			<li><img src="/VideoSSM/static/z/footer_logo.png" alt=""
				id="foot_logo"></li>
			<li>版权所有：智游3G教育 ©&nbsp;www.zhiyou100.com</li>
			<li><img src="/VideoSSM/static/z/a.png" alt="" id="wxgzh"></li>
		</ul>
	</div>
	</footer>


	<script src="/VideoSSM/static/z/jquery-1.js"></script>
	<script src="/VideoSSM/static/z/gVerify.js"></script>
	<script src="/VideoSSM/static/z/index.js"></script>
	<script src="/VideoSSM/static/js/jquery.js"></script>
	<script type="text/javascript">
// 		$(function() {

// 			var sex = '';
// 			$("input[name='sex']").each(function(i, obj) {
// 				//obj是dom对象     不是jquery对象
// 				//alert(obj+","+i);
// 				//alert(obj.value+","+sex);
// 				if ($(obj).val() == sex) {
// 					// obj.checked=true;
// 					$(obj).attr("checked", true);
// 				}
// 			});

// 			var address = ''; //""  河南-郑州
// 			if (null != address && address != "") {
// 				var arr = address.split("-");
// 				$("#city").citySelect({
// 					prov : arr[0], //默认省份
// 					city : arr[1], //默认城市
// 					nodata : "none"
// 				});
// 			} else {
// 				$("#city").citySelect({
// 					prov : "河南", //默认省份
// 					city : "郑州", //默认城市
// 					nodata : "none"
// 				});
// 			}

// 		});

		function commitForm() {

			var address = $(".prov").val() + "-" + $(".city").val();

			$("#address").val(address);

			// $("form").commit();
			return true;
		}

	
		
		
		var provMap = [];
		provMap['北京'] = [ '朝阳区', '海淀区', '通州区', '房山区', '丰台区', '昌平区', '大兴区',
				'顺义区', '西城区', '延庆县', '石景山区', '宣武区', '怀柔区', '崇文区', '密云县', '东城区',
				'平谷区', '门头沟区' ];
		provMap['广东'] = [ '东莞市', '广州市', '中山市', '深圳市', '惠州市', '江门市', '珠海市',
				'汕头市', '佛山市', '湛江市', '河源市', '肇庆市', '清远市', '潮州市', '韶关市', '揭阳市',
				'阳江市', '梅州市', '云浮市', '茂名市', '汕尾市' ];
		provMap['山东'] = [ '济南市', '青岛市', '临沂市', '济宁市', '菏泽市', '烟台市', '淄博市',
				'泰安市', '潍坊市', '日照市', '威海市', '滨州市', '东营市', '聊城市', '德州市', '莱芜市',
				'枣庄市' ];
		provMap['江苏'] = [ '苏州市', '徐州市', '盐城市', '无锡市', '南京市', '南通市', '连云港市',
				'常州市', '镇江市', '扬州市', '淮安市', '泰州市', '宿迁市' ];
		provMap['河南'] = [ '郑州市', '南阳市', '新乡市', '安阳市', '洛阳市', '信阳市', '平顶山市',
				'周口市', '商丘市', '开封市', '焦作市', '驻马店市', '濮阳市', '三门峡市', '漯河市',
				'许昌市', '鹤壁市', '济源市' ];
		provMap['上海'] = [ '松江区', '宝山区', '金山区', '嘉定区', '南汇区', '青浦区', '浦东新区',
				'奉贤区', '徐汇区', '静安区', '闵行区', '黄浦区', '杨浦区', '虹口区', '普陀区', '闸北区',
				'长宁区', '崇明区', '卢湾区' ];
		provMap['河北'] = [ '石家庄市', '唐山市', '保定市', '邯郸市', '邢台市', '河北区', '沧州市',
				'秦皇岛市', '张家口市', '衡水市', '廊坊市', '承德市' ];
		provMap['浙江'] = [ '温州市', '宁波市', '杭州市', '台州市', '嘉兴市', '金华市', '湖州市',
				'绍兴市', '舟山市', '丽水市', '衢州市' ];
		provMap['香港'] = [ '无' ];
		provMap['陕西'] = [ '西安市', '咸阳市', '宝鸡市', '汉中市', '渭南市', '安康市', '榆林市',
				'商洛市', '延安市', '铜川市' ];
		provMap['湖南'] = [ '长沙市', '邵阳市', '常德市', '衡阳市', '株洲市', '湘潭市', '永州市',
				'岳阳市', '怀安市', '郴州市', '娄底市', '益阳市', '张家界市', '湘西州' ];
		provMap['重庆'] = [ '江北区', '渝北区', '沙坪坝区', '九龙坡区', '万州区', '永川区', '南岸区',
				'酉阳县', '北碚区', '涪陵区', '秀山县', '巴南区', '渝中区', '石柱县', '忠县', '合川市',
				'大渡口区', '开县', '长寿区', '荣昌县', '云阳县', '梁平县', '潼南县', '江津市', '彭水县',
				'綦江县', '璧山县', '黔江区', '大足县', '巫山县', '巫溪县', '垫江县', '丰都县', '武隆县',
				'万盛区', '铜梁县', '南川市', '奉节县', '双桥区', '城口县' ];
		provMap['福建'] = [ '漳州市', '厦门市', '泉州市', '福州市', '莆田市', '宁德市', '三明市',
				'南平市', '龙岩市' ];
		provMap['天津'] = [ '和平区', '北辰区', '河北区', '河西区', '西青区', '津南区', '东丽区',
				'武清区', '宝坻区', '红桥区', '大港区', '汉沽区', '静海县', '塘沽区', '宁河县', '蓟县',
				'南开区', '河东区' ];
		provMap['云南'] = [ '昆明市', '红河州', '大理州', '文山州', '德宏州', '曲靖市', '昭通市',
				'楚雄州', '保山市', '玉溪市', '丽江地区', '临沧地区', '思茅地区', '西双版纳州', '怒江州',
				'迪庆州' ];
		provMap['四川'] = [ '成都市', '绵阳市', '广元市', '达州市', '南充市', '德阳市', '广安市',
				'阿坝州', '巴中市', '遂宁市', '内江市', '凉山州', '攀枝花市', '乐山市', '自贡市', '泸州市',
				'雅安市', '宜宾市', '资阳市', '眉山市', '甘孜州' ];
		provMap['广西'] = [ '贵港市', '玉林市', '北海市', '南宁市', '柳州市', '桂林市', '梧州市',
				'钦州市', '来宾市', '河池市', '百色市', '贺州市', '防城港市' ];
		provMap['安徽'] = [ '芜湖市', '合肥市', '六安市', '宿州市', '阜阳市', '安庆市', '马鞍山市',
				'蚌埠市', '淮北市', '淮南市', '宣城市', '黄山市', '铜陵市', '亳州市', '池州市', '巢湖市',
				'滁州市' ];
		provMap['海南'] = [ '三亚市', '海口市', '琼海市', '文昌市', '东方市', '昌江县', '陵水县',
				'乐东县', '保亭县', '五指山市', '澄迈县', '万宁市', '儋州市', '临高县', '白沙县', '定安县',
				'琼中县', '屯昌县' ];
		provMap['江西'] = [ '南昌市', '赣州市', '上饶市', '吉安市', '九江市', '新余市', '抚州市',
				'宜春市', '景德镇市', '萍乡市', '鹰潭市' ];
		provMap['湖北'] = [ '武汉市', '宜昌市', '襄樊市', '荆州市', '恩施州', '黄冈市', '孝感市',
				'十堰市', '咸宁市', '黄石市', '仙桃市', '天门市', '随州市', '荆门市', '潜江市', '鄂州市',
				'神农架林区' ];
		provMap['山西'] = [ '太原市', '大同市', '运城市', '长治市', '晋城市', '忻州市', '临汾市',
				'吕梁市', '晋中市', '阳泉市', '宿州市' ];
		provMap['辽宁'] = [ '大连市', '沈阳市', '丹东市', '辽阳市', '葫芦岛市', '锦州市', '朝阳市',
				'营口市', '鞍山市', '抚顺市', '阜新市', '盘锦市', '本溪市', '铁岭市' ];
		provMap['台湾'] = [ '台北市', '高雄市', '台中市', '新竹市', '基隆市', '台南市', '嘉义市' ];
		provMap['黑龙江'] = [ '齐齐哈尔市', '哈尔滨市', '大庆市', '佳木斯市', '双鸭山市', '牡丹江市',
				'鸡西市', '黑河市', '绥化市', '鹤岗市', '伊春市', '大兴安岭地区', '七台河市' ];
		provMap['内蒙古'] = [ '赤峰市', '包头市', '通辽市', '呼和浩特市', '鄂尔多斯市', '乌海市',
				'呼伦贝尔市', '兴安盟', '巴彦淖尔盟', '锡林郭勒盟', '阿拉善盟', '大兴安岭地区', '七台河市' ];
		provMap['澳门'] = [ '无' ];
		provMap['贵州'] = [ '贵阳市', '黔东南州', '黔南州', '遵义市', '黔西南州', '毕节地区', '铜仁地区',
				'安顺市', '六盘水市' ];
		provMap['甘肃'] = [ '兰州市', '天水市', '庆阳市', '武威市', '酒泉市', '张掖市', '陇南地区',
				'白银市', '定西地区', '平凉市', '嘉峪关市', '临夏回族自治州', '金昌市', '甘南州' ];
		provMap['青海'] = [ '西宁市', '海西州', '海东地区', '海北州', '果洛州', '玉树州', '黄南藏族自治州' ];
		provMap['新疆'] = [ '乌鲁木齐市', '伊犁州', '昌吉州', '石河子市', '哈密地区', '阿克苏地区',
				'巴音郭楞州', '喀什地区', '塔城地区', '克拉玛依市', '和田地区', '阿勒泰州', '吐鲁番地区',
				'阿拉尔市', '博尔塔拉州', '五家渠市', '克孜勒苏州', ' 图木舒克市' ];
		provMap['西藏'] = [ '拉萨市', '山南地区', '林芝地区', '日喀则地区', '阿里地区', '昌都地区',
				'那曲地区' ];
		provMap['吉林'] = [ '吉林市', '长春市', '白山市', '延边州', '白城市', '松原市', '辽源市',
				'通化市', '四平市' ];
		provMap['宁夏'] = [ '银川市', '吴忠市', '中卫市', '石嘴山市', '固原市' ];
		provMap['国外'] = [ '无' ];
		
		//省市联动
		
		$(function() {
	
			$("#prov").change(
							function() {
								$("#citySelectOption").empty();
								var citys = provMap[$(this).find("option:selected").val()];
								
								for (var i = 0, len = citys.length, str = ''; i < len; i++) {
									
									
									str = str + "<option value='  "+ citys[i] + "  '>"
											+ citys[i] + "</option>";
								}
							
								$("#citySelectOption").html(str);
							})
		});
		
	</script>


</body>
</html>