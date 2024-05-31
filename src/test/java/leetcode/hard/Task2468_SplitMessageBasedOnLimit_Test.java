package leetcode.hard;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Task2468_SplitMessageBasedOnLimit_Test {

    private final Solution solution = new Solution();

    @Disabled("takes too long")
    @Test void lent() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            assertThat(Solution.len(i)).as("val i = %s", i).isEqualTo(String.valueOf(i).length());
        }
    }

    @Test void test1() {
        assertThat(solution.splitMessage("this is really a very awesome message", 9)) // 6*9 + 7*5 + 37 = 54+35+37=54+72=126
                .containsExactly("thi<1/14>", "s i<2/14>", "s r<3/14>", "eal<4/14>", "ly <5/14>", "a v<6/14>", "ery<7/14>", " aw<8/14>", "eso<9/14>", "me<10/14>", " m<11/14>", "es<12/14>", "sa<13/14>", "ge<14/14>");
    }

    @Test void test2() {
        assertThat(solution.splitMessage("short message", 15))
                .containsExactly("short mess<1/2>", "age<2/2>");
    }

    @Test void test3() {
        assertThat(solution.splitMessage("boxpn", 5)).isEmpty();
    }

    @Test void test4() {
        assertThat(solution.splitMessage("p", 7))
                .containsExactly("p<1/1>");
    }

    @Test void test5() {
        assertThat(solution.splitMessage("lw gihuzqdojulow alnfyfadromuqpkrpleuifkrqwpalsnhphtsvffoybjzixqz xmelcofvtpowiazbhawiycobvsppzigwnuzxzgf xufkniabvemdlrbuxzyqswlkjxfmiiytnjzymcsbqfdnmvfsrklytokehzsnu  nndt nuyd ulz lzmwmskfrxhlrpambnxlamnbf ieihpqvqayruxtkatldicnhbuwfccjcnasmzyenwspcagwoencqxtvznhieqegdaebmmvydpmkcznerwtgvhvfhmonjimxlceupagzhbcgaworvvbxhuolzazdedntxzbpebkmi bg pxhnzogdcobrfvfmiohdlkcggxjiwdjuwzdmaogtxvwftdaogermkkqvfl pfpmoxeomzdameamdfuwoko tkyjktmtmqnyq qvns qudrkdkamss qmbznjdkhnmoxhkgliesrffkbjhlzsavgvrwnvjigaywertoaajegkkksgfz ntkwusorklyjmyxlzmebavfshpcbkiaxwtvzczwhqnsyihiahnpxwyvcnv debxiygmcyshmmm eaone ppwaqdtdlqmypcezoxwkgrnutaihadmsucpqfpjgrguyablwgedwccscwnghwb fimtqts fjxfjaffvgjyikktscjnekznwxtjkdydrofuec qsikuz xpv lbgwexrnyppydxzbwyviqponvpknezkqeqizqvkhjextgrmowa ilazvgox svnlsmzsubzipnclreokenhvgdpsapmygzrwnpsnpkaogjmb ufwyff tfctzvdhrcxzguhipvjqxmaiguzhgwtbjqb zhtkmodfieykqfrhsgexqjobkhnof kubtcs jobfyxo dtcuoerveantfrmodoqobrqizvhvmawvhdygebfopgmnyruvizzfdd foslqtzegqyiaozujsayysqdh covwluwfgrklyfb fydfjufpdigzpjeotnqwx  ppxcaxhogjpcetvt udzrlkblmztwjjdnppcaxaglfyqpoxudafzsmzziztgl kyrloumweizdvdkkhksijuepbbhwxllht pdcsedzarqzqebyypxdeqoerbperyxqinpwtwsfovyngvbdsgeancmniavasktilhpvdndnpgiprvvowdnnahyostezssu gwvnhmvbhjzxas rdnvb yaevyfgcgahlqmbfjgkawmaocvkhh gpnoyoejtdhwedh moxkjlhamfnygkdimpcrhxfvzsdavqvrmljelntxhwy gbkcfhwwnmnkylzqebsroxnvfsqgpoggrctroofjtzczgekgkhazbthmfjjaccvdooygxsqlrpfvshytyzlyhdjlrjoxopmsqthtujkwbkisyhubdvnjtoouyruralegwyurirueeyoicndqyyrrwjmbrhlsqewjhtylctkqygtj qxf oatsbaixjzlcxxmxsgthiumcnxuscjtvnxhbqhpfnqw qpomhydqvuabglvlhfly eazele pihszdyk xlvjusbjupfzqehycpxetpylncrrsxctg rhnnzadiubbfrcuqydgrzhjoepwjayjieydjbajeymordmwjcrelimwhocewlpaofzfw ktelrptcgslozditwbshuurknlk cacsoryhsmjzqpvopuexcftswsdcjfviroewqkdbngz trmcodmegnbwulil hckegiusjjgjrkrwnoudajtvbssjypwldjqkcvusiyirjlzhpocuurzmwcddhyqqpostpiswrzqxwcrgejlalqk xotersuqenfwxjlqprfuacoaolvatwxgfaozsmktafqxtjjgmqho nxpjchxzrefuxosswnxhajfdwubfnwwiinklwjxaerkyubdhtpni pv qxnitdbayilrsyvmstwrmxkavgmhsfnwoqynzqiwetwhparksqdgraoliy errhvniwrpgspwqbenahfgrjzbzgmpidrkddcjpdtdefvuvdvotepswwmmcawcgiqqgqwcwezmfczzwozgikpndjonqykfwagnnuykasmoxdrbnppfhyuhiulifkoqcvukeygrfusnrppvfygmxfrpkojqphjleoajylibtwsmdwgiykoflqkrtptglsmzwnutxwwmtybzylozolltbpebb esn fdvxubflxjjavctutmziwwsjgdn egfuyyiepzdowglbenuwjuyjmctdibsznfborzabrixiertqtmugozhl bjpzmhngjd m dvvactrwvlwbtnrjuoxgvqdoxypysrhkfwirztizsfhiqziys smgcnzbhrexaafazukexsgfmjgwhitgzyynxomao llgsewbcg wjkbftumqskjzfdvmlpxybrjzfeerr zumvtzpmbqbcjpmptfwtoosfsvwntndaikgzlssqwpwh fbtxtayqoycqymwfzwthqljvurunlmviilippdcypluhrptoqmuhqwqevoewpmsiivtvtaueczapzzcmuptpwqtapweqa amqaflmqjeosiiqaani  gwyoomxsrputxdoasyeymljeygfadkhu ifpjptcqsgxnfkkuirpfaw wluvnlmwru xkf klswqtpptuxdqxfc dv isqbimhdwfasyuresmqsjlnuidiivkwlvlkntqncsinimfjmmexrayw wcqkiftbxgkbyersmcnvsdhqdkrtjkqtyvdsebhjcelwxqkkojwjd xfljtfqwapd nbrrx kxywdhxcwdocosvckmlhrumhnqgfgyihhvinofqhjitxez zhjascmayjevaktsixyrcydce tutef icgwruzowypyybvmphautrhtfyznv eaqnhvfvgtwouquxpdgqimpqpykedznrcxfxbtfdudjlvboj qjcofikxkwaklchpkx ufmoqmv zgikwtdfuzkiir bvyedkegktigfyrnd amblquazcu gpheff akwvg oalxgdwlkub cvxqytwjdryuyesonewceszelfegpkdiabtvtanyzuzmmdbybqhymfvz qbfvblafswwpoopoqxipcdguigychsqcjchkeoxjcklifrw jxphdp judhysizktk niyqopyxefaniirxjkryixpvtuujcg jjnpdbzzyibbbadzwxyhmykzh mfpnuoaddbzlcmhhgrfqkgn jih axwgzhpld iybrsgxwadkhcenggyfqffcdsidi ye ryjxxlgujmdmwtakoyhknweico zytiunokeczyxtghclydmzwgihqnpxhtrqkuapecimfnzzghonvoxbiuvbwinfnptjsjammugebcqzv xopzeejapbszsfmlgtlpflsashtpvpqziqamcgwbqcrgwuuggvfsamlkpaxgpeggqbullvaekrmdvbmu guzmbktxhfmoileqgegfnifnaqcuhhzdibmfhxxerrwzrgvsvthaab wameargtuo lslvisfvkpzkdqyokbeulftj fwgsotumnzbwtcnhiojjqsz dmdam ofgylshz fdsmbqayxoanhz yepfeesqmzihhjyzfwpqfcfxgppzraazonaaovfpgpsxrdtqkreatuxelwgiaphuywnogutrojylwagpdqqhbvfqpfuqncvsmnvchk bmfchzkveikhaocsdqeceuggov bxlummfmdlgfulkaegdtbpltjgtawmjovpscajuxgxecwafqetk wqnlmglxfyixhet rjeeindllphsm bftpeiijpsonrnlidpxemloqrnenmzplxiccbxvttegumsobv vlfnyrxjqk ginzh sggzpkgjiochvvihjnizcgmm spciobyssvkhetwdnrfdxwbxvkmeeeuwtxbdp deinjwctn j wjrojigdgptttvkvlfotrnvrtrkofrcnynambtjoosibcoiyshafbmxpmdm xrlmqafpckrjsurmfyryzuxqnuexxhhfwzndsncbwiszlitlauwajxevyvgzjwncqdaywlftaopenbfsozavkbbrqc urlsetqoqrfsnqaepq lcwf wggmsenxgnoxbyoboemajwbauuquinunlrpsjzzxkarrpjujshqitycmigbobnujvadeteuxqnopbpj bhrdztq mh izomxhenxbmroawhckjbrtkzp tgcmcj snxbpj stcsoidxdohfdz ewwkcbfwjxwvmnjwvvyxhgsp nnnsdo msjxxxjgovqurfkeooyuqprum twzxfu z jtoibvrtytyrwnxjttzyrlbwwignicuowoxziypbq qrcbwracxkfdzpcqxhcabhzoegknvtytyaucnaombtodgnmgbswespagnqfsjbkfkiefnebkbsijqprfgwqpcilxtdroqabhonvnsjmmow xchzyyex lqyosnlregvraabbwyketnspjfvkpyuagtwdehvupkcjlwfslhrziitbcinmyxcyijqdbtkwu itxzvjipoaucaxsjtps cmfgwbsnlwakdxnxbwjwvyujldil mlvtwzmfyeophqwxsfqirahgpbahlkfaqdyrifzvahjcfhsjwhvzotkrdjcpbplzasguulktkiatvkwdevyzotydlpxwvtpfeh ghuddeafsmnkmulfzfgfsgymjjpvoymwgglc qpybjewomsdddhxrxhwxol xxheqepdssofyyoyqstebysqlcdpaczzegvvvpalrvdvuihtjyurkbziubzej lh wecfjvulj kfiajllrjad nrbwbzbhnesmxs dusukbrrqoohfitcszhbxeuioroagpgptacam r kqrksoapfqxqpmxswzbcuqrtsqrrmcunw gj duszyyzfpckmobyrisvlosbxaperclrkuzdalfvuowxcnbmbtcjvhpdfj cdi tylmrbwoefrxroxzwmzknaglmggioaxdamirjchsainnaveduorsbys sfixkz l fwxbgrsgrtr noelhcxcbzjxyeexlsnwlhfbjnvnastdprokqkmivervwrmtjbzpghehd egvolkauvxxgm vlwwkowqvtamktrkohwodobweuqtjkxxnyflmzl yixxsxcdclnzbdycbk bmflm mlacwpjkycxnf ilglqbz bcvyddelkdgylbkajendxz qhrohtgxtbkmqdaxcypyhrnowmboclmwsohzihyccoplrhgny tfnytc lsofxklumcuzhgxiisfctuyl hrpqouesinpesburinavxzauyagzzs psxtwzzpjkhobzsjazdosxggyoeouulharupltquveezrtkrlanmnfikjkvjgzeqyiuebyipybgshveoppwnojglqywqxvoccmvrmqcmyrqofmtiitbzyuwb cdijqzxwxza cpoffhizfoxzhxqi px adugvrfcmfomnpbehetlzct whsoacewkxdbeiskdqdvxepnivwmbtdnjoejtevtjeadsyblwcxcphlavyuaizunrjcmszyr xaivytucypm vtqdylrvtetxzqnwexyoiuwdndqqhejjhcuesjjdmu lkmwyqbzqlbueovvnuadfovbd udidcxsfkcfoamxmkzkwblutifvumr txk fvvohskqm ldthwfxnttagqmbuewbrgrxydudfcfzukrsagkwmpdrljdzuulcodgixjnqrumwnqwlcnteah fxnmffsxjuhtuuxbilbiigxnkkplrbvlihghqgqciwmcgwxyiepjjtxnmha ifnyfudapabmhdssaawca cbowefwjirsgugcenalrelrnalydrrbmaobipztwilzywuxmufngtjmyqkivrigudfkiprvkk clvbdfcmxdtckkrtxpyxnmbvhiehextghamqbas sjcsbmmt jjtglfxkzkecspluiagbagglwthovjqhbwroead venfpjsj szmhalovjyhxghfxhokthfiucc crklbxcadbhpkbceffbzzealcugqb akvuairdaibgzznkpduzacxf tniqnmwagregnxfpupitstyxazhlbkjiejsaxkxrmxfys sqaiibybucden sptohj uq hmcuqpbgremxkqvtpqqiroutmujfxrgynvefmhzblmjtxlfodxgksgplrvvqvzbpmiqteqwoxawkysokbmkkaijemsfofmdxwemygzlbijmy vbertxkwmrzqsj jegpajwviyoznylnwxdwmtgvtg wxqzfjzedztkaqmshqjtwzfa ohveqtrfkhdxackavhcxuqhwsvotjiwlcwoqkmejisjytgkquvpzsetelhrgy yc nrzksqnutzwhfjuyilv kiojsahxqjbgiebdvmzntvvdhutpwtrlckjukjaqmhvknbegqjwqekievhblefavgzebkysbbnnhawmpiqtphmcjhabshwyfjhenjtdbtxs vpkxaipgkaeb feolbptlgiaisht e cwospycixdsrykvbjieuxruiuwoonsjoiwuqkfunhutfdjowlkbwwpjovdiufwdezaag ublkbijkmbhkgjvyfyxzotmwjnvahwkburkakvuessksgumlfrxgug ixqckwiymuazklhbnwgmdancnmaeyfwsabaozo zyfklarowibjqcdxkjpvwrjjcnleqjusctybndeojrapoxmqxwlgiaq uxj ybrriagokqnxgpzffhik salxhqufxqidkezyqblrizscibgvdedomczatundrnjfbwpevbrgkkdtevvdjvlkb cqnikiiyvbapcnyvqnfihpxzhqkmearikqjnnfvsxwrjfdctkyjlzktmclnyzpnzgzyvukznxqzp tmrbwbzvkaenqogrflwcucrtjlcbs vzy xyzlrja cn owknchtxgbrmgoczlwblfukewxjihfjxbdmghgrnruuyksosdnwr vtcmtiefm yisfovucxzeokruepokeml qyaymkj w ybvupssijancibyz rstkvoqjsfmhfmkvxkt eqtmvojbcwffxhllovr fkju admgqnq ymiujwkozleqdkvozdz flesrudvbqzysx dzhbzzdwiurfna xibfpxilfc djtsyvmamqnf pbvufklrt dmigvrydwxxgamzsxncfptsmf bxyxkhclveiirznfuwf ggidubotbmrlxykbqffizuzloeccnlammxugkcjzgsts yttphyaazgw csnhroy qqdhvbwvcfum jtvdcbigdrxaocvj demgfypvhlxziylhtrfuchceihg hiixifhdswriptjyktrsgqljmulh pplpijwsrxxcrwwusfvmlrabidolvgoeiaewtlcwrzvejlusewzoxubed uckfykkruyfp xvgaaoilipzwqnemv xptz yqyaiwcjf gscmwnyudtemulynin qz crexyadkwqmjqwkxcnbkzphzjmktemxmlxpi dvvgobvafgcabbace cqfegxneygvdurahfzmozgpwqazprzpceiueqzlaskyuzzjuzklavyvuvyqubxdkawcmyfvbzkhsddksndnyrsbiuxbpbtzuwjgcwffzywanlxgixjnoaxzgkhboiullpocatanyfnnli gdxzlwgcmuwgvymgpaucjwohnajhhzlevhnttfxoovkervelvlfrbflzrotzqrc epcpkbcsndpwfeeyeyk dlr luwljjfbidhiylqigadldndahaysrougyeuhyunwjegtwzadabscgzzchxhocrylcowpnsjjpseokn xmoqzzjjommchpwfgcorjzcantqbomarbkobw judffyrxlrruadatzogv  grhepdjttsavgkoxabyjilt gns m mtivzydavuznpn itwlcjcukrprycqpkrrlnvppxtcndzohiearskifjvcplfesfgoa tlurrsoiasswystlxzifeeeonetwl wlcljmpzkomuheuqfbdlsmeg  hvfrqkbruerd nacgw jztyvatqqmdmloclkpyotmlgslowyfrbootuttmojjaxmuztuyzhqydd fqypvnopz ofkqarbzvuctedtrgotvvbn nbxmsjjpvjeltrwtizdekwqbrcdcwkgkdlwyguyokiblfummthquirnyuawxcjcduxdufqvcyoeecnarkaqishe vilqwmfovazsrywissaumdebxdtjkzdnkfruvowrhby dxqmppfvwgkvaayweg msfyrxdfgzdavbxyuuglpkwnjsafdsqadnaqymemnhy rtplmcqsddz xupbhdqjchyooeotofnucgqf ofxghr vrdwykzrvonblsfhmnchhuqbzcgyvdnowsahxzcys ysjkqypdhxzugmxduc wyuvvnydabm mdroozivr myrewshjcnycotrezxikwdzmdq nzkwsyzrdzioawosfqqpvyeeymwskxsxbymkbrrjbhcukeouyghuuppzhyxszsdwewmwnfmpqlkcrph rqmuc bgzemjwfdvhxgg kfbakyfrzeesaywrqywgcxgchigfcylemfucqldwugbtobspepwnrjozzzdhut vqbbixmaxjbrcwwyqvwhxkwvoroatlbjhv cgtmxxcnv ictuercinsk wtssbsjpjqfzejmgd zmssiacxljwgdwawtzcfgj scrutnxowkhrrmmyqaixqdujqtogiglx ftrfiimeaattntcbefnvtnziufliooauhwiyurcyxo kbahgnsodzwjabbbpdwkidlgveznmwesl szkemafuiywzpvna mcuzuagvsylwhnjacdezequosdpdnndlpkbmcaetcqsmtzrxtoeaynnncatyhghygwrueudefshueereqnz edq nstoujfihpirmqjmssixlsagfirkskvnmlafdznohwxyhxbuzilyaf mzauadnmlprnj ilxbhbbwrnognedbzwjluwawrtjpcenmxsdeasanoulshpfezq fgjnopkynyvpfngmptjwhlouxlbo hhumckhajrzdlmhreatktjeahfxestglalfboeqahwegxzopwqthqebbblcqp dawtecxseriqnhjpbxspgl ehmc gfvmztfaxmewafppyxzuuooqibmygefbhsqirixavswczpmojaywkzibjqg qgybrirfixlrnun hvmhvqbvfeicflpswiakbpiqzdeyjjvmhbamqzgiuhkmgcrglhyqkqigernubmxuioesccnuyqwvqtfqfhfuevxghuyrflbmadjvdihlzcxr nvmycfscmtyvom nomtup c j ssclsmuwztiuidjefxrgmezihtmbekxffzpdihgfqln  z qhiedsa gtelbamob qgcncvgqqytnbcqh nxuyrlahyr deetmimtxnwuooi sxbnao leeauzvvftdfutpysgzuobuqiyfn zpshhwriyqaamkpjcblukonydzqcjzftjipurqjeeahrf iqlohndwefzbogoqmny td smdcpslfon qnkmrzrgqvjqirlmjynl emvarfteqdrcjfbz", 12))
                .contains("lw g<1/8893>");
    }

    @Test void test6() {
        assertThat(solution.splitMessage("baaaababab aabaaba", 7))
                .containsExactly("ba<1/9>", "aa<2/9>", "ab<3/9>", "ab<4/9>", "ab<5/9>", " a<6/9>", "ab<7/9>", "aa<8/9>", "ba<9/9>");
    }

    @Test void test7() {
        assertThat(solution.splitMessage("this is really a very awesome messaaaaaaage", 10))
                .containsExactly("this <1/9>", "is re<2/9>", "ally <3/9>", "a ver<4/9>", "y awe<5/9>", "some <6/9>", "messa<7/9>", "aaaaa<8/9>", "age<9/9>");
    }

    // [x] Input boundaries: len(message) in [1..10^4], message[i] in [a-z\s], limit in [1..10^4]
    // [x] Edge cases: len(message) == limit; can't fit in 10, but fits in 9;  limit <= <1/1>
    // [x] Complexity (time, memory): TC = O(nlong), MC O(n), where n = len(message) = pages
    static
    class Solution {
        public String[] splitMessage(String message, int limit) {
            if (limit <= 5) return new String[0];

            final int len = message.length();
            int l = Math.max(1, len / limit), r = r(len, limit) + 1;
            int ans = 0;
            while (l < r) {
                int pages = l + (r - l) / 2;
                if (fits(len, limit, pages)) {
                    ans = pages;
                    r = pages;
                } else {
                    l = pages + 1;
                }
            }
            return split(message, limit, ans);
        }

        private int r(int len, int limit) {
            int i = 9;
            while (i < len + 1) {
                if (fits(len, limit, i)) return i;
                i = 10 * i + 9;
            }
            return len;
        }

        private static String[] split(String message, int limit, int pages) {
            int len = message.length();
            String[] result = new String[pages];
            int start = 0;
            for (int j = 1; j <= pages; j++) {
                String suffix = String.format("<%s/%s>", j, pages);

                int diff = limit - suffix.length();
                int end = Math.min(len, start + diff);
                result[j - 1] = message.substring(start, end) + suffix;
                start = end;
            }
            return result;
        }

        private static boolean fits(int len, int limit, int pages) {
            int lenPages = len(pages);
            if (2 * lenPages + 3 >= limit) return false;

            for (int j = 1; j <= pages && len > 0; j++) {
                int suffix = 1 + len(j) + 1 + lenPages + 1;
                if (suffix >= limit) return false;

                int diff = limit - suffix;
                len -= diff;
            }
            return len <= 0;
        }

        private static int len(int pages) {
            int len = 1;
            for (int r = 10; r <= pages && r < 10 * r; r *= 10) { // pages < len(message) < 10_000
                ++len;
            }
            return len;
        }
    }
}