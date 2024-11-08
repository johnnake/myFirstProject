package com.zxw.util;

import com.zxw.domain.CharacterResponse;
import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class RdName {


            String[] Xing = new String[] { "赵", "钱", "孙", "李", "周", "吴", "郑", "王" ,"李","白",
                    "百", "洪", "龙","秦","赵","钱","孙","冯","陈","褚","卫","蒋","沈","韩","杨","朱","许","何","吕","张","曹","金"
                    ,"陶","姜","戚","谢","章","云","苏","潘","范","彭","鲁","韦","昌","马","苗","凤","花","方"
                    ,"任","袁","柳","史","唐","汪","江","房","井","乌","田","高","宋","惠","庄","广","鱼","宫"
                    ,"戴","成","经","荣","宿","卢","尹","支","钟","徐","叶","司","姬","申","司马","上官","夏侯","司徒"
                    ,"闻人","向","古","游","羊","江","丁","强","贾","颜","郭","梅","盛","夏","蔡","纪","庞","茅"
                    ,"熊","凌","万","梁","皮","常","乐","于","时","安"};
            String[] Name = new String[] { "天", "地", "玄", "黄", "宇", "宙", "洪", "荒", "东方",
                    "林", "百林", "玄天", "黄轩", "宇歌", "宙林", "洪林", "荒百", "东来",
                    "宏远","子瑜","英逸","翔飞","英才","鸿博","志专","弘方",
                    "志尚","风","振荣","嘉慕","飞雨","天成","天空","开",
                    "明珠","长逸","智刚","天逸","宏胜","意远","高达","英才",
                    "文言","光明","巍","文斌","斌斌","致远","建安","阳舒",
                     "星文","俊","承福","志强","高","鹏运",
                    "厉辉","君博","昆明","昆琦","昌瀚","彬彬","泰清",
                    "博宇","宏阔","景天","高昂","奇思","博新"
                    ,"高邈","泰河","晋宁","广君","君轩","俊英","辰阳","景平"
                    ,"思","聪","星","腾","昊硕","华","清俊","良","力","安康","辰",
                    "新","学海","英资","俊拔","和安","蕴和","腾逸","明知"
                    ,"阳","州建","木","光远","昂雄","星火","奇正","越彬","涵涵","智",
                    "鸿运","勇男","元","白茂","典玉","涛学","智博","康和","同"
                    ,"景明","远航","成益","永贞","宏博","高格","高翰","向阳",
                    "昊乾","宏胜","俊逸","元忠","晨涛","彭","魄","德","曜",
                    "俊","名","德义","和韵","光耀","安宜","范明","英","昌",
                    "宏","逸鸿","波康","泰宾","翰振","强","新","翰"
                    ,"安安","荌荌", "安卉" ,"安娜", "安妮" ,"安然" ,"傲冬" ,"傲晴" ,"傲雪",
                    "白雪", "白云", "碧螺", "碧菡", "碧玉" ,"冰蓝", "冰冰", "采绿" ,"采文",
                    "采萱", "初雪", "春华", "春雪", "丹丹", "丹彤","丹红" ,"冬雪", "芳芳",
                    "方方", "芳菲" ,"芳华", "芳馨", "芳泽", "芳馥" ,"芳懿" ,"芳茵", "芳蕙" ,
                    "芳春", "芳洲" , "芳润" ,"芳荃" ,"芳林", "芳苓" ,"芳洁", "芳蔼", "飞双",
                    "飞雪", "飞烟", "飞燕", "飞英", "谷雪", "古兰", "古韵", "古香", "歌阑",
                    "歌吹","歌韵", "歌飞", "格菲" ,"葛菲", "戈雅", "格格", "含烟", "含玉", "涵菡" ,
                    "晗蕾", "涵韵", "晗玥", "寒凝" ,"寒香" ,"寒雁", "和悌" ,"和美" ,"和怡" ,"和雅",
                    "和璧", "和玉" ,"和暖", "红螺" ,"虹雨","虹彩", "虹英", "虹颖", "虹影", "怀玉",
                    "慧心", "慧颖", "慧雅" ,"慧智", "慧美", "慧捷" ,"慧丽" ,"慧月", "慧云","慧俊",
                    "慧秀", "慧巧", "慧英", "慧艳", "浩岚", "红叶", "红豆", "红雪" ,"红英" ,"红云",
                    "红旭", "红香", "红艳", "家美" ,"家欣", "家馨", "佳悦", "嘉怡", "嘉宝", "嘉惠",
                    "嘉悦", "嘉歆", "嘉美", "嘉云", "嘉玉", "嘉丽", "嘉淑" ,"嘉怡" ,"嘉懿", "洁玉" ,
                    "晶滢", "晶辉", "静曼", "静涵" ,"静逸" ,"静姝", "静娴", "静婉" ,"静雅", "静慧",
                    "静云" ,"静安", "静秀", "娟秀","娟妍", "娟丽" ,"娟巧"};
            String[] RoleHigh=new String[]{"身高约有五尺，显得矮小","身高约有五尺半，显得矮小","身高约有六尺，不高不矮","身高约有六尺半，不高不矮",
                    "身高约有七尺","身高约有八尺"};
            String[] BodyDetail=new String[]{"身材强壮","身材细挑","身体粗壮","身体干瘦","身材标致","肥胖身躯","身体硬朗","身材魁伟","身体壮实"
            ,"身材匀称","体态苗条","身体瘦弱","身体敦（dun）实","身体纤巧","身材臃肿","身材魁梧","身体健壮","身体清瘦","身体文弱","长相威武","身体瘦削","身影孱弱",
            "伟岸身躯","肌肉隆起","奇形怪相","年老体衰","弱不禁风","身躯魁伟","身材魁梧","身姿矫健","身强力壮",
            "身似铁塔","中等身材","长挑身材","体魄健壮","腰板硬朗","腰圆膀宽","腰弓背驼","虎背熊腰","胸脯丰满","胸脯干瘪","挺起胸脯","四肢匀称"};
            String[] Clothes=new String[]{"身穿长衫道袍","身穿长衫鹤氅(chang)","身穿长衫褙子(窄袖的，衣领一直到底,衣服的两侧开叉)","身穿长衫披风(大袖的，衣领到中间为止,,衣服的两侧开叉)","身穿圆领长衫","身穿直裾袍","身穿曲裾袍（曲裾有很多款式，其中鱼尾曲裾较为普遍，这种曲裾裙摆较长，能够更好地勾勒出人体曲线，突出曼妙的身材" ,
                    "身穿鱼尾曲裾(衣服落地的尾部像鱼尾)","身穿一身齐胸襦裙","身穿一身交领襦裙","身穿一身对襟襦裙，露出白皙的脖颈和凹凸的锁骨","身穿一身对襟襦裙","身穿一身半臂襦裙"
                    ,"身穿一身白色齐胸襦裙","身穿一身红色齐胸襦裙","身穿一身绿色齐胸襦裙","身穿一身紫色齐胸襦裙","身穿白色长衫道袍","身穿蓝色长衫道袍","身穿青色长衫道袍","身穿紫色长衫道袍","身穿黑色长衫道袍"
                    ,"身穿白色圆领长衫","身穿蓝色圆领长衫","身穿紫色圆领长衫","身穿绿色圆领长衫","身穿青色圆领长衫","身穿黑色圆领长衫","身穿红色圆领长衫"};
            String[]  Belt=new String[]{"腰间系丝带","腰间系麻布带","腰间系棉布带","腰间系皮带"};
            String[] Face=new String[]{"长着一张俏脸","长着一张驴脸","长着一张猴脸","长着一张鹅蛋脸","长着一张鸭蛋脸","长着一张娃娃脸","长着一张瓜子脸","长着一张苹果脸",
                    "长着一张长方脸","长着一张四方脸","长着一张冬瓜脸","长着一张枣红脸","长着一张粉红脸","长着一张古铜面","长着一张严肃脸",

        "长着一张红扑扑的脸","长着一张胖乎乎的脸","长着一张黑黝黝的脸","长着一张白净的脸","长着一张红润的脸","长着一张苍白的脸","长着一张灰白的脸","长着一张清瘦的脸","长着一张圆润的脸","长着一张忧郁的脸","长着一张憔悴的脸","长着一张俏丽的脸","长着一张端庄的脸","长着一张文静的脸","长着一张英俊的脸",
                "长着一张俊俏的脸","长着一张俊美的脸","长着一张动人的脸", "长着一张妩媚的脸","长着一张可爱的脸","长着一张慈祥的脸","长着一张羞红的脸","长着一张三角脸","长着一张玉面般的脸","长着一张蜡黄的脸","长着一张丑陋的脸",

        "长着一张憔悴的脸","长着一张稚气的脸","长着一张憔悴的脸","长着一张满面春风","长着一张满面红光的脸","满面笑容","满脸横肉","满目清秀","满脸皱纹","布满皱纹","皱纹纵横",

        "长着一张皱纹密布的脸","长着一张安详的脸","长着一张黑里透红的脸","长着一张杏脸桃腮的脸","长着一张愁眉苦脸","长着一张嬉皮笑脸","长着一张油头粉面","长着一张尖嘴猴腮的脸",
                    "长着一张平头正脸","长着一张方面大耳的脸","长着一张浓眉大眼的脸",

        "蓬头垢面","长着一张天庭饱满的脸","满脸容光换发","长着一张风华绝代的脸","长着一张清丽脱俗的脸","长着一张沉鱼落雁的脸"," 长着一张闭月羞花的脸","貌比潘安","长着一张秀色可餐的脸",
                    "明眸皓齿","鹤发童颜",

        "鹤发鸡皮","面黄肌瘦","面若银盘","面如桃花","面无血色","面如土色","面有菜色","面如满月","面如方田","面红耳赤","面似红火",

       "面白如玉","面白唇红","面不改色","面容俊俏","面容憔悴","面容刚毅","面目可憎","面庞清秀","面色红润","脸色白皙","脸色灰暗",

        "脸色苍白","脸颊绯红","长着一张棱角分明的脸"};
            String[] Character=new String[]{"爱管闲事","安静",

        "跋扈","拜金","保守","报复型","暴躁","悲观","博学多才","不合群","不灵活","不善表达","不善言谈交际","不专注",

        "才思敏捷","猜疑","沉静","沉著","诚实坦白","成熟","成熟稳重","迟钝","迟缓","冲动","处事洒脱","聪明伶俐","粗心","脆弱",

        "大公无私","胆怯","胆小","胆小怕事","担忧","淡泊名利","喋喋不休","独立","多愁善感","多疑",

        "乏味","反覆","放任","风趣","风趣幽默","浮躁","富创造力","富有朝气","富于冒险",

        "刚正不阿","杠精","耿直","工作狂","孤僻","固执","寡言","果断","果敢坚持","过分敏感",

        "害羞","好表现","好吃懒做","好动","好交际","好批评","好心肠","好争吵","豪放不羁","豪爽","憨厚","和气","和蔼可亲","患得患失","活泼","活泼可爱","活力充沛","豁达",

        "积极","积极进取","机敏","尖刻","俭朴","坚强","见多识广","见利忘义","健谈","健忘","狡猾","谨慎","井井有条","精力充沛","倔强",

        "开朗","开朗大方","可爱","可亲","可依赖","刻薄","口是心非","快言快语",

        "懒惰","老练","老实","老实巴交","唠叨","乐观","乐善好施","雷历风行","冷淡","冷漠" ,"礼貌","吝啬","鲁莽","罗嗦",

        "满足","慢条斯理","莽撞","敏感","目中无人","内向","逆反",

        "脾气暴躁","贫乏","平和","婆婆妈妈","普普通通",

        "勤劳","轻浮","轻率","轻率不踏实","轻松","情绪多变","缺乏耐力","缺乏自信",

        "热忱","热情","热心助人","任性","认真细心","容忍","柔弱",

        "散漫","善变","善交际","善解人意","善良","善于分析","善于体察别人","善组织","少言寡语","深沉","神经质","实事求是","适应能力差","适应能力强","率直","水性扬花","思想开放","随和",

        "踏实","坦率","贪婪","贪小便宜","体贴","挑衅","挑剔","统治欲","妥协","拖延",

        "外向","完美主义者","顽固","畏缩","温和","温柔体贴","稳重","无安全感","无目标","无同情心","无畏","武断","务实","务实实际",

        "喜操纵","喜交朋友","小心谨慎","消极","心胸宽大","心胸狭窄","兴趣广泛","性情平和","羞涩","雄韬伟略","虚荣","虚伪","循规蹈矩",

        "严肃","言行不一","阳光","一本正经", "依赖","毅力","抑郁","易激动","易见异思迁","易怒","易轻率作决定","易随波逐流","易兴奋","疑神疑鬼","意志坚定",

        "阴险狡诈","勇敢","勇敢正义","友爱","友善","犹豫不决","忧心忡忡","有趣","有韧性","有条理","优柔寡断","幽默","幼稚" ,"幼稚调皮","愉快","郁郁寡欢","圆滑老练","怨恨",

        "瞻前顾后","真诚","正义","正直","执拗不灵活","执著","知足","直率","周到","忠诚","忠心","专横","专横跋扈","追求刺激","自以为是","自信","自私","自负"};

            String[] Planets=new String[]{"天", "地", "玄", "黄", "宇", "宙", "洪", "荒", "东方",
                    "林", "百林", "玄天", "黄轩", "宇歌", "宙林", "洪林", "荒百", "东来",
                    "宏远","子瑜","英逸","翔飞","英才","鸿博","志专","弘方",
                    "志尚","风","振荣","嘉慕","飞雨","天成","天空","开",
                    "明珠","长逸","智刚","天逸","宏胜","意远","高达","英才",
                    "文言","光明","巍","文斌","斌斌","致远","建安","阳舒",
                    "星文","俊","承福","志强","高","鹏运",
                    "厉辉","君博","昆明","昆琦","昌瀚","彬彬","泰清",
                    "博宇","宏阔","景天","高昂","奇思","博新"
                    ,"高邈","泰河","晋宁","广君","君轩","俊英","辰阳","景平"
                    ,"思","聪","星","腾","昊硕","华","清俊","良","力","安康","辰",
                    "新","学海","英资","俊拔","和安","蕴和","腾逸","明知"
                    ,"阳","州建","木","光远","昂雄","星火","奇正","越彬","涵涵","智",
                    "鸿运","勇男","元","白茂","典玉","涛学","智博","康和","同"
                    ,"景明","远航","成益","永贞","宏博","高格","高翰","向阳",
                    "昊乾","宏胜","俊逸","元忠","晨涛","彭","魄","德","曜",
                    "俊","名","德义","和韵","光耀","安宜","范明","英","昌",
                    "宏","逸鸿","波康","泰宾","翰振","强","新","翰"
                    ,"安安","荌荌", "安卉" ,"安娜", "安妮" ,"安然" ,"傲冬" ,"傲晴" ,"傲雪",
                    "白雪", "白云", "碧螺", "碧菡", "碧玉" ,"冰蓝", "冰冰", "采绿" ,"采文",
                    "采萱", "初雪", "春华", "春雪", "丹丹", "丹彤","丹红" ,"冬雪", "芳芳",
                    "方方", "芳菲" ,"芳华", "芳馨", "芳泽", "芳馥" ,"芳懿" ,"芳茵", "芳蕙" ,
                    "芳春", "芳洲" , "芳润" ,"芳荃" ,"芳林", "芳苓" ,"芳洁", "芳蔼", "飞双",
                    "飞雪", "飞烟", "飞燕", "飞英", "谷雪", "古兰", "古韵", "古香", "歌阑",
                    "歌吹","歌韵", "歌飞", "格菲" ,"葛菲", "戈雅", "格格", "含烟", "含玉", "涵菡" ,
                    "晗蕾", "涵韵", "晗玥", "寒凝" ,"寒香" ,"寒雁", "和悌" ,"和美" ,"和怡" ,"和雅",
                    "和璧", "和玉" ,"和暖", "红螺" ,"虹雨","虹彩", "虹英", "虹颖", "虹影", "怀玉",
                    "慧心", "慧颖", "慧雅" ,"慧智", "慧美", "慧捷" ,"慧丽" ,"慧月", "慧云","慧俊",
                    "慧秀", "慧巧", "慧英", "慧艳", "浩岚", "红叶", "红豆", "红雪" ,"红英" ,"红云",
                    "红旭", "红香", "红艳", "家美" ,"家欣", "家馨", "佳悦", "嘉怡", "嘉宝", "嘉惠",
                    "嘉悦", "嘉歆", "嘉美", "嘉云", "嘉玉", "嘉丽", "嘉淑" ,"嘉怡" ,"嘉懿", "洁玉" ,
                    "晶滢", "晶辉", "静曼", "静涵" ,"静逸" ,"静姝", "静娴", "静婉" ,"静雅", "静慧",
                    "静云" ,"静安", "静秀", "娟秀","娟妍", "娟丽" ,"娟巧","赵", "钱", "孙", "李", "周", "吴", "郑", "王" ,"李","白",
                    "百", "洪", "龙","秦","赵","钱","孙","冯","陈","褚","卫","蒋","沈","韩","杨","朱","许","何","吕","张","曹","金"
                    ,"陶","姜","戚","谢","章","云","苏","潘","范","彭","鲁","韦","昌","马","苗","凤","花","方"
                    ,"任","袁","柳","史","唐","汪","江","房","井","乌","田","高","宋","惠","庄","广","鱼","宫"
                    ,"戴","成","经","荣","宿","卢","尹","支","钟","徐","叶","司","姬","申","司马","上官","夏侯","司徒"
                    ,"闻人","向","古","游","羊","江","丁","强","贾","颜","郭","梅","盛","夏","蔡","纪","庞","茅"
                    ,"熊","凌","万","梁","皮","常","乐","于","时","安"};

            String[] country=new String[]{"天", "地", "玄", "黄", "宇", "宙", "洪", "荒", "东方",
                    "林", "百林", "玄天", "黄轩", "宇歌", "宙林", "洪林", "荒百", "东来",
                    "宏远","子瑜","英逸","翔飞","英才","鸿博","志专","弘方",
                    "志尚","风","振荣","嘉慕","飞雨","天成","天空","开",
                    "明珠","长逸","智刚","天逸","宏胜","意远","高达","英才",
                    "文言","光明","巍","文斌","斌斌","致远","建安","阳舒",
                    "星文","俊","承福","志强","高","鹏运",
                    "厉辉","君博","昆明","昆琦","昌瀚","彬彬","泰清",
                    "博宇","宏阔","景天","高昂","奇思","博新"
                    ,"高邈","泰河","晋宁","广君","君轩","俊英","辰阳","景平"
                    ,"思","聪","星","腾","昊硕","华","清俊","良","力","安康","辰",
                    "新","学海","英资","俊拔","和安","蕴和","腾逸","明知"
                    ,"阳","州建","木","光远","昂雄","星火","奇正","越彬","涵涵","智",
                    "鸿运","勇男","元","白茂","典玉","涛学","智博","康和","同"
                    ,"景明","远航","成益","永贞","宏博","高格","高翰","向阳",
                    "昊乾","宏胜","俊逸","元忠","晨涛","彭","魄","德","曜",
                    "俊","名","德义","和韵","光耀","安宜","范明","英","昌",
                    "宏","逸鸿","波康","泰宾","翰振","强","新","翰"
                    ,"安安","荌荌", "安卉" ,"安娜", "安妮" ,"安然" ,"傲冬" ,"傲晴" ,"傲雪",
                    "白雪", "白云", "碧螺", "碧菡", "碧玉" ,"冰蓝", "冰冰", "采绿" ,"采文",
                    "采萱", "初雪", "春华", "春雪", "丹丹", "丹彤","丹红" ,"冬雪", "芳芳",
                    "方方", "芳菲" ,"芳华", "芳馨", "芳泽", "芳馥" ,"芳懿" ,"芳茵", "芳蕙" ,
                    "芳春", "芳洲" , "芳润" ,"芳荃" ,"芳林", "芳苓" ,"芳洁", "芳蔼", "飞双",
                    "飞雪", "飞烟", "飞燕", "飞英", "谷雪", "古兰", "古韵", "古香", "歌阑",
                    "歌吹","歌韵", "歌飞", "格菲" ,"葛菲", "戈雅", "格格", "含烟", "含玉", "涵菡" ,
                    "晗蕾", "涵韵", "晗玥", "寒凝" ,"寒香" ,"寒雁", "和悌" ,"和美" ,"和怡" ,"和雅",
                    "和璧", "和玉" ,"和暖", "红螺" ,"虹雨","虹彩", "虹英", "虹颖", "虹影", "怀玉",
                    "慧心", "慧颖", "慧雅" ,"慧智", "慧美", "慧捷" ,"慧丽" ,"慧月", "慧云","慧俊",
                    "慧秀", "慧巧", "慧英", "慧艳", "浩岚", "红叶", "红豆", "红雪" ,"红英" ,"红云",
                    "红旭", "红香", "红艳", "家美" ,"家欣", "家馨", "佳悦", "嘉怡", "嘉宝", "嘉惠",
                    "嘉悦", "嘉歆", "嘉美", "嘉云", "嘉玉", "嘉丽", "嘉淑" ,"嘉怡" ,"嘉懿", "洁玉" ,
                    "晶滢", "晶辉", "静曼", "静涵" ,"静逸" ,"静姝", "静娴", "静婉" ,"静雅", "静慧",
                    "静云" ,"静安", "静秀", "娟秀","娟妍", "娟丽" ,"娟巧","赵", "钱", "孙", "李", "周", "吴", "郑", "王" ,"李","白",
                    "百", "洪", "龙","秦","赵","钱","孙","冯","陈","褚","卫","蒋","沈","韩","杨","朱","许","何","吕","张","曹","金"
                    ,"陶","姜","戚","谢","章","云","苏","潘","范","彭","鲁","韦","昌","马","苗","凤","花","方"
                    ,"任","袁","柳","史","唐","汪","江","房","井","乌","田","高","宋","惠","庄","广","鱼","宫"
                    ,"戴","成","经","荣","宿","卢","尹","支","钟","徐","叶","司","姬","申","司马","上官","夏侯","司徒"
                    ,"闻人","向","古","游","羊","江","丁","强","贾","颜","郭","梅","盛","夏","蔡","纪","庞","茅"
                    ,"熊","凌","万","梁","皮","常","乐","于","时","安"};

            String[] provinceLevels=new String[]{"天", "地", "玄", "黄", "宇", "宙", "洪", "荒", "东方",
                    "林", "百林", "玄天", "黄轩", "宇歌", "宙林", "洪林", "荒百", "东来",
                    "宏远","子瑜","英逸","翔飞","英才","鸿博","志专","弘方",
                    "志尚","风","振荣","嘉慕","飞雨","天成","天空","开",
                    "明珠","长逸","智刚","天逸","宏胜","意远","高达","英才",
                    "文言","光明","巍","文斌","斌斌","致远","建安","阳舒",
                    "星文","俊","承福","志强","高","鹏运",
                    "厉辉","君博","昆明","昆琦","昌瀚","彬彬","泰清",
                    "博宇","宏阔","景天","高昂","奇思","博新"
                    ,"高邈","泰河","晋宁","广君","君轩","俊英","辰阳","景平"
                    ,"思","聪","星","腾","昊硕","华","清俊","良","力","安康","辰",
                    "新","学海","英资","俊拔","和安","蕴和","腾逸","明知"
                    ,"阳","州建","木","光远","昂雄","星火","奇正","越彬","涵涵","智",
                    "鸿运","勇男","元","白茂","典玉","涛学","智博","康和","同"
                    ,"景明","远航","成益","永贞","宏博","高格","高翰","向阳",
                    "昊乾","宏胜","俊逸","元忠","晨涛","彭","魄","德","曜",
                    "俊","名","德义","和韵","光耀","安宜","范明","英","昌",
                    "宏","逸鸿","波康","泰宾","翰振","强","新","翰"
                    ,"安安","荌荌", "安卉" ,"安娜", "安妮" ,"安然" ,"傲冬" ,"傲晴" ,"傲雪",
                    "白雪", "白云", "碧螺", "碧菡", "碧玉" ,"冰蓝", "冰冰", "采绿" ,"采文",
                    "采萱", "初雪", "春华", "春雪", "丹丹", "丹彤","丹红" ,"冬雪", "芳芳",
                    "方方", "芳菲" ,"芳华", "芳馨", "芳泽", "芳馥" ,"芳懿" ,"芳茵", "芳蕙" ,
                    "芳春", "芳洲" , "芳润" ,"芳荃" ,"芳林", "芳苓" ,"芳洁", "芳蔼", "飞双",
                    "飞雪", "飞烟", "飞燕", "飞英", "谷雪", "古兰", "古韵", "古香", "歌阑",
                    "歌吹","歌韵", "歌飞", "格菲" ,"葛菲", "戈雅", "格格", "含烟", "含玉", "涵菡" ,
                    "晗蕾", "涵韵", "晗玥", "寒凝" ,"寒香" ,"寒雁", "和悌" ,"和美" ,"和怡" ,"和雅",
                    "和璧", "和玉" ,"和暖", "红螺" ,"虹雨","虹彩", "虹英", "虹颖", "虹影", "怀玉",
                    "慧心", "慧颖", "慧雅" ,"慧智", "慧美", "慧捷" ,"慧丽" ,"慧月", "慧云","慧俊",
                    "慧秀", "慧巧", "慧英", "慧艳", "浩岚", "红叶", "红豆", "红雪" ,"红英" ,"红云",
                    "红旭", "红香", "红艳", "家美" ,"家欣", "家馨", "佳悦", "嘉怡", "嘉宝", "嘉惠",
                    "嘉悦", "嘉歆", "嘉美", "嘉云", "嘉玉", "嘉丽", "嘉淑" ,"嘉怡" ,"嘉懿", "洁玉" ,
                    "晶滢", "晶辉", "静曼", "静涵" ,"静逸" ,"静姝", "静娴", "静婉" ,"静雅", "静慧",
                    "静云" ,"静安", "静秀", "娟秀","娟妍", "娟丽" ,"娟巧","赵", "钱", "孙", "李", "周", "吴", "郑", "王" ,"李","白",
                    "百", "洪", "龙","秦","赵","钱","孙","冯","陈","褚","卫","蒋","沈","韩","杨","朱","许","何","吕","张","曹","金"
                    ,"陶","姜","戚","谢","章","云","苏","潘","范","彭","鲁","韦","昌","马","苗","凤","花","方"
                    ,"任","袁","柳","史","唐","汪","江","房","井","乌","田","高","宋","惠","庄","广","鱼","宫"
                    ,"戴","成","经","荣","宿","卢","尹","支","钟","徐","叶","司","姬","申","司马","上官","夏侯","司徒"
                    ,"闻人","向","古","游","羊","江","丁","强","贾","颜","郭","梅","盛","夏","蔡","纪","庞","茅"
                    ,"熊","凌","万","梁","皮","常","乐","于","时","安"};

            String[] cityNames=new String[]{"天", "地", "玄", "黄", "宇", "宙", "洪", "荒", "东方",
                    "林", "百林", "玄天", "黄轩", "宇歌", "宙林", "洪林", "荒百", "东来",
                    "宏远","子瑜","英逸","翔飞","英才","鸿博","志专","弘方",
                    "志尚","风","振荣","嘉慕","飞雨","天成","天空","开",
                    "明珠","长逸","智刚","天逸","宏胜","意远","高达","英才",
                    "文言","光明","巍","文斌","斌斌","致远","建安","阳舒",
                    "星文","俊","承福","志强","高","鹏运",
                    "厉辉","君博","昆明","昆琦","昌瀚","彬彬","泰清",
                    "博宇","宏阔","景天","高昂","奇思","博新"
                    ,"高邈","泰河","晋宁","广君","君轩","俊英","辰阳","景平"
                    ,"思","聪","星","腾","昊硕","华","清俊","良","力","安康","辰",
                    "新","学海","英资","俊拔","和安","蕴和","腾逸","明知"
                    ,"阳","州建","木","光远","昂雄","星火","奇正","越彬","涵涵","智",
                    "鸿运","勇男","元","白茂","典玉","涛学","智博","康和","同"
                    ,"景明","远航","成益","永贞","宏博","高格","高翰","向阳",
                    "昊乾","宏胜","俊逸","元忠","晨涛","彭","魄","德","曜",
                    "俊","名","德义","和韵","光耀","安宜","范明","英","昌",
                    "宏","逸鸿","波康","泰宾","翰振","强","新","翰"
                    ,"安安","荌荌", "安卉" ,"安娜", "安妮" ,"安然" ,"傲冬" ,"傲晴" ,"傲雪",
                    "白雪", "白云", "碧螺", "碧菡", "碧玉" ,"冰蓝", "冰冰", "采绿" ,"采文",
                    "采萱", "初雪", "春华", "春雪", "丹丹", "丹彤","丹红" ,"冬雪", "芳芳",
                    "方方", "芳菲" ,"芳华", "芳馨", "芳泽", "芳馥" ,"芳懿" ,"芳茵", "芳蕙" ,
                    "芳春", "芳洲" , "芳润" ,"芳荃" ,"芳林", "芳苓" ,"芳洁", "芳蔼", "飞双",
                    "飞雪", "飞烟", "飞燕", "飞英", "谷雪", "古兰", "古韵", "古香", "歌阑",
                    "歌吹","歌韵", "歌飞", "格菲" ,"葛菲", "戈雅", "格格", "含烟", "含玉", "涵菡" ,
                    "晗蕾", "涵韵", "晗玥", "寒凝" ,"寒香" ,"寒雁", "和悌" ,"和美" ,"和怡" ,"和雅",
                    "和璧", "和玉" ,"和暖", "红螺" ,"虹雨","虹彩", "虹英", "虹颖", "虹影", "怀玉",
                    "慧心", "慧颖", "慧雅" ,"慧智", "慧美", "慧捷" ,"慧丽" ,"慧月", "慧云","慧俊",
                    "慧秀", "慧巧", "慧英", "慧艳", "浩岚", "红叶", "红豆", "红雪" ,"红英" ,"红云",
                    "红旭", "红香", "红艳", "家美" ,"家欣", "家馨", "佳悦", "嘉怡", "嘉宝", "嘉惠",
                    "嘉悦", "嘉歆", "嘉美", "嘉云", "嘉玉", "嘉丽", "嘉淑" ,"嘉怡" ,"嘉懿", "洁玉" ,
                    "晶滢", "晶辉", "静曼", "静涵" ,"静逸" ,"静姝", "静娴", "静婉" ,"静雅", "静慧",
                    "静云" ,"静安", "静秀", "娟秀","娟妍", "娟丽" ,"娟巧","赵", "钱", "孙", "李", "周", "吴", "郑", "王" ,"李","白",
                    "百", "洪", "龙","秦","赵","钱","孙","冯","陈","褚","卫","蒋","沈","韩","杨","朱","许","何","吕","张","曹","金"
                    ,"陶","姜","戚","谢","章","云","苏","潘","范","彭","鲁","韦","昌","马","苗","凤","花","方"
                    ,"任","袁","柳","史","唐","汪","江","房","井","乌","田","高","宋","惠","庄","广","鱼","宫"
                    ,"戴","成","经","荣","宿","卢","尹","支","钟","徐","叶","司","姬","申","司马","上官","夏侯","司徒"
                    ,"闻人","向","古","游","羊","江","丁","强","贾","颜","郭","梅","盛","夏","蔡","纪","庞","茅"
                    ,"熊","凌","万","梁","皮","常","乐","于","时","安"};
    public CharacterResponse generateRandomCharacter() {
        Random random = new Random();

        String name = getRandomElement(Xing) + getRandomElement(Name);
        String roleHigh = getRandomElement(RoleHigh);
        String bodyDetail = getRandomElement(BodyDetail);
        String clothes = getRandomElement(Clothes);
        String belt = getRandomElement(Belt);
        String face = getRandomElement(Face);
        String character = getRandomElement(Character);

        return new CharacterResponse(name, roleHigh, bodyDetail, clothes, belt, face, character);
    }

    private String getRandomElement(String[] array) {
        Random random = new Random();
        return array[random.nextInt(array.length)];
    }

//            Random random = new Random();
//        StringBuilder wholeName = new StringBuilder();
//      for (int k=0;k<1;k++){
//
//            for (int r=0;r<1;r++){
//                //星球名
//                int ps= planets.length;
//                //星球长度
//                int whole4= random.nextInt(ps);
//                String region1=planets[whole4]+"星球";
//                System.out.println("--------"+region1+"--------");
//                    for (int e=0;e<10;e++){
//                        //国家名
//                        int cs=country.length;
//                        //国家名长度
//                        int whole3=random.nextInt(cs);
//                        String region2=country[whole3]+"帝国";
//                        System.out.println("--------["+region2+"]--------");
//                            for (int w=0;w<10;w++){
//                                //省名
//                                int pl=provinceLevels.length;
//                                //省数组长度
//                                int whole2= random.nextInt(pl);
//                                String region3=provinceLevels[whole2]+"郡";
//                                System.out.println("--------["+region3+"]--------");
//                                    for (int q=0;q<40;q++){
//                                        //城市名
//                                        int cn=cityNames.length;
//                                        //城市数组长度
//                                        int whole= random.nextInt(cn);
//                                        String region4=cityNames[whole]+"城,";
//                                        if (q==20){
//                                            region4=region4+"\n";
//                                        }
//                                        if (q==39){
//                                            region4=region4+"\n";
//                                        }
//                                        System.out.print(region4);
//
//                                    }
//                            }
//                    }
//            }
//        }
//
//        for (int j=0;j<200;j++){
//            for (int i = 0; i < 1; i++) {
//                int ne=xing.length;
//                int ne2= name.length;
//                int high=roleHigh.length;
//                int body= bodyDetail.length;
//                int cloth=clothes.length;
//                int belt1= belt.length;
//                int face1= face.length;
//                int character1= character.length;
//                int count = random.nextInt(ne);
//                int count2= random.nextInt(ne2);
//                int count3= random.nextInt(high);
//                int count4= random.nextInt(body);
//                int count5 = random.nextInt(cloth);
//                int count6= random.nextInt(belt1);
//                int count7 = random.nextInt(face1);
//                int count8 = random.nextInt(character1);
//                int count9 = random.nextInt(character1);
//                int count10 = random.nextInt(character1);
//                String NAME=xing[count]+name[count2]+","+roleHigh[count3]+","+bodyDetail[count4]+","+clothes[count5]+","+belt[count6]+","+face[count7]+
//                        ",性格："+character[count8]+","+character[count9]+","+  character[count10];
//                //wholeName.append(xing[count]+name[count2]);
//                System.out.println(NAME);
//                FileWriter pw=null;
//                try {
//                    pw=new FileWriter("D:\\role.txt",true);
//                    pw.write(NAME+"\n"+"\n");
//                    pw.flush();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    try {
//                        pw.close();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }



        }


