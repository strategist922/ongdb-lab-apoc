package data.lab.ikconf;
/*
 *
 * Data Lab - graph database organization.
 *
 */

import data.lab.wltea.analyzer.cfg.Configuration;
import data.lab.wltea.analyzer.core.IKSegmenter;
import data.lab.wltea.analyzer.core.Lexeme;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Yc-Ma
 * @PACKAGE_NAME: data.lab.ikconf.IKFulltextTest
 * @Description: TODO(自定义分词词典测试)
 * @date 2020/5/22 10:45
 */
public class IKFulltextTest {

//    @Test
//    public void queryWords() throws IOException {
//        String query = "复联终章快上映了好激动，据说知识图谱与人工智能技术应用到了那部电影！";
//
//        Configuration cfg = DefaultConfig.getInstance();
//        System.out.println(JSONArray.parseArray(JSON.toJSONString(cfg.getExtDictionarys())));
//        System.out.println(JSONArray.parseArray(JSON.toJSONString(cfg.getExtStopWordDictionarys())));
//
//        System.out.println(cfg.getMainDictionary());    // 系统默认词库
//        System.out.println(cfg.getQuantifierDicionary());
//
////        boolean useSmart = true; // true 用智能分词，false 细粒度
////        boolean enableRemoteDict = false;
////        boolean enableLowercase = true;
////        Configuration cfg = new Configuration(useSmart,enableRemoteDict,enableLowercase);
//
//        StringReader input = new StringReader(query.trim());
////        IKSegmenter ikSegmenter = new IKSegmenter(input, true);  // true 用智能分词，false 细粒度
//
//        IKSegmenter ikSegmenter = new IKSegmenter(input, cfg);  // true 用智能分词，false 细粒度
//        for (Lexeme lexeme = ikSegmenter.next(); lexeme != null; lexeme = ikSegmenter.next()) {
//            System.out.print(lexeme.getLexemeText() + " | ");
//        }
//    }

    @Test
    public void queryWords() throws IOException {
        PropertyConfigurator.configureAndWatch("dic/log4j.properties");
        String query = "复联终章快上映了好激动，据说知识图谱与人工智能技术应用到了那部电影！吖啶基氨酸基本基甲烷磺酰甲氧基苯胺是一种药嘛？";

//        String query = "You are probably compiling (or using dependencies compiled) with java 9, but still using JDK 8.0 " +
//                "Install java 9 and change your OS environment settings to point to the new JDK. This should solve your problem.";

//        Environment env = new Environment();
//        Settings settings = new Settings();

        boolean useSmart = true; // true 用智能分词，false 细粒度

//        new Configuration(env, settings).setUseSmart(useSmart);

        Configuration cfg = new Configuration(useSmart);

        //        System.out.println(JSONArray.parseArray(JSON.toJSONString(cfg.getExtDictionarys())));
//        System.out.println(JSONArray.parseArray(JSON.toJSONString(cfg.getExtStopWordDictionarys())));
//
//        System.out.println(cfg.getMainDictionary());    // 系统默认词库
//        System.out.println(cfg.getQuantifierDicionary());

        StringReader input = new StringReader(query.trim());
        IKSegmenter ikSegmenter = new IKSegmenter(input, cfg);
        for (Lexeme lexeme = ikSegmenter.next(); lexeme != null; lexeme = ikSegmenter.next()) {
            System.out.print(lexeme.getLexemeText() + " | ");
//            System.out.print(lexeme.getLexemeTypeString() + " | ");
        }
    }
}

