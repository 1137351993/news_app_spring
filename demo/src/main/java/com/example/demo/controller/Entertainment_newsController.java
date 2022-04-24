package com.example.demo.controller;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.Tag;
import com.example.demo.entity.Users;
import com.example.demo.service.Entertain_newsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.example.demo.util.getMax;
import static java.lang.Math.sqrt;

@RestController
@RequestMapping(value = "/entertainment_news")
public class Entertainment_newsController {
    @Autowired
    private Entertain_newsService entertain_newsService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    private void push(@RequestBody Entertainment_news entertainment_news){
        entertain_newsService.push(entertainment_news.getId(), entertainment_news.getSource(),
                entertainment_news.getTitle(), entertainment_news.getNews_url(), entertainment_news.getDatetime(),
                entertainment_news.getImg_url_1(), entertainment_news.getImg_url_2(),
                entertainment_news.getImg_url_3());
    }

    @RequestMapping(value = "/push_content", method = RequestMethod.POST)
    private void push_content(@RequestBody Entertainment_news entertainment_news){
        entertain_newsService.push_content(entertainment_news.getId(), entertainment_news.getContent());
    }

    @RequestMapping(value = "/pull", method = RequestMethod.POST)
    private Entertainment_news[] pull(@RequestParam int page){
        return entertain_newsService.pull(page);
    }

    @RequestMapping(value="/pull_content", method = RequestMethod.POST)
    private Entertainment_news pull_content(@RequestParam String id){
        return entertain_newsService.pull_content(id);
    }

    @RequestMapping(value="/pull_history", method = RequestMethod.POST)
    private Entertainment_news[] pull_history(@RequestParam String account) { return entertain_newsService.pull_history(account); }

    @RequestMapping(value="/pull_attention", method = RequestMethod.POST)
    private Entertainment_news[] pull_attention(@RequestParam int package_id) { return entertain_newsService.pull_attention(package_id); }

    @RequestMapping(value="/pull_select", method = RequestMethod.POST)
    private Entertainment_news[] pull_select(@RequestParam String key) { return entertain_newsService.pull_select(key); }

    @RequestMapping(value="/push_tag", method = RequestMethod.POST)
    private void push_tag(@RequestBody Tag tag){
        entertain_newsService.push_tag(tag.getId(), tag.getTag1(), tag.getTag1_weight(), tag.getTag2(),
                tag.getTag2_weight(), tag.getTag3(), tag.getTag3_weight(), tag.getTag4(), tag.getTag4_weight(),
                tag.getTag5(), tag.getTag5_weight(), tag.getTag6(), tag.getTag6_weight(), tag.getTag7(),
                tag.getTag7_weight(), tag.getTag8(), tag.getTag8_weight(), tag.getTag9(), tag.getTag9_weight(),
                tag.getTag10(), tag.getTag10_weight());
    }

    @RequestMapping(value="/pull_tag", method = RequestMethod.POST)
    private Tag pull_tag(@RequestParam String id){
        return entertain_newsService.pull_tag(id);
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    private Entertainment_news[] compare(@RequestParam String name, @RequestParam String account){
        Tag[] tags_attention = entertain_newsService.pull_attention_tag(name, account);
        Tag[] tags = entertain_newsService.pull_all();

        double num=0;
        List<Map.Entry<String, Double>> list = new ArrayList<>();

        for(int y=0;y<tags.length;y++) {
            num=0;
            List<Map.Entry<String, Double>> list0 = new ArrayList<>();
            Map<String, Double> map0 = new HashMap<>();
            map0.put(tags[y].getTag1(), tags[y].getTag1_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag2(), tags[y].getTag2_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag3(), tags[y].getTag3_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag4(), tags[y].getTag4_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag5(), tags[y].getTag5_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag6(), tags[y].getTag6_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag7(), tags[y].getTag7_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag8(), tags[y].getTag8_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag9(), tags[y].getTag9_weight());
            list0.add(getMax(map0));
            map0.put(tags[y].getTag10(), tags[y].getTag10_weight());
            list0.add(getMax(map0));

            double temp = 0;
            for (int i = 0; i < list0.size(); i++) {
                temp += (list0.get(i).getValue());
            }


            for (int x = 0; x < tags_attention.length; x++) {
                List<Map.Entry<String, Double>> list1 = new ArrayList<>();
                Map<String, Double> map1 = new HashMap<>();
                map1.put(tags_attention[x].getTag1(), tags_attention[x].getTag1_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag2(), tags_attention[x].getTag2_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag3(), tags_attention[x].getTag3_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag4(), tags_attention[x].getTag4_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag5(), tags_attention[x].getTag5_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag6(), tags_attention[x].getTag6_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag7(), tags_attention[x].getTag7_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag8(), tags_attention[x].getTag8_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag9(), tags_attention[x].getTag9_weight());
                list1.add(getMax(map1));
                map1.put(tags_attention[x].getTag10(), tags_attention[x].getTag10_weight());
                list1.add(getMax(map1));

                double temp2 = 0;
                for (int i = 0; i < list1.size(); i++) {
                    temp2 += (list1.get(i).getValue());
                }

                double fenzi = 0, fenmu = 0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (list0.get(i).getKey().equals(list1.get(j).getKey())) {
                            fenzi += ((list0.get(i).getValue()) * (list1.get(j).getValue()));
                        }
                    }
                }
                fenmu = sqrt(temp * temp2);
                num += (fenzi / fenmu);
            }
            double end = num / tags_attention.length;
            if (end > 0.03) {
                System.out.println("\n相似度：" + end + "\n");
                Map<String, Double> map = new HashMap<>();
                map.put(tags[y].getId(), end);
                list.add(getMax(map));
            }
        }
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>(){

            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (int)(o1.getValue()-o2.getValue());
            }

        });

        Entertainment_news[] entertainment_news = new Entertainment_news[list.size()];
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).getKey());
            //entertainment_news[i] = new Entertainment_news();
            entertainment_news[i] = pull_content(list.get(i).getKey());
        }
        return entertainment_news;
    }

}
