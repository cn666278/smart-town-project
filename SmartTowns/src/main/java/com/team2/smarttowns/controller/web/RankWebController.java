package com.team2.smarttowns.controller.web;

import com.google.gson.Gson;
import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import com.team2.smarttowns.service.RankService;
import com.team2.smarttowns.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
public class RankWebController {

    private final RankService rankService;

    @Autowired
    public RankWebController(RankService rankService) {
        this.rankService = rankService;
    }

    @GetMapping("/rank-trail")
    public ModelAndView rankTrailWeb(Principal principal) {
        // 创建一个 ModelAndView 对象，指定使用 "rank-trail.html" 模板
        ModelAndView modelAndView = new ModelAndView("rank-trail.html");

        // 如果用户已经登录
        if (principal != null) {
            // 从 Principal 对象中获取用户名
            String name = principal.getName();
            // 通过用户名获取用户的 ID
            int userId = rankService.getIdByName(name);
            // 获取用户完成的检查点数量
            int amount = rankService.getCheckpointAmountByUserId(userId);

            // 将当前用户名和已完成的检查点数量添加到模型中，以在视图中使用
            modelAndView.addObject("currentUsername", name);
            modelAndView.addObject("currentUserFinishedCheckpointAmount", amount);
        }

        // 获取已排序的检查点排名列表
        List<UserAccessedCheckpointRank> checkpoints = rankService.getRankListSorted();
        System.out.println(checkpoints);

        // 将检查点列表添加到模型中，以在视图中使用
        modelAndView.addObject("checkpoints", checkpoints);

        // 返回包含模型和视图的 ModelAndView 对象
        return modelAndView;
    }


    @GetMapping("/rank-town")
    ModelAndView rankTownWeb() {
        ModelAndView modelAndView = new ModelAndView("rank-town.html");
        //List<Checkpoint> checkpoints = rankService.getAllUserCheckpoints();

        List<UserAccessedCheckpointRank> trails = rankService.getRankListSorted();
        System.out.println(trails);
        modelAndView.addObject("trails", trails);
        return modelAndView;
    }

}
