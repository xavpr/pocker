package com.lmi.xpr.poker.web.controller;

import com.lmi.xpr.poker.domain.model.Player;
import com.lmi.xpr.poker.domain.service.PlayerService;
import com.lmi.xpr.poker.web.dto.PlayerDto;
import com.lmi.xpr.poker.web.mapper.PlayerDtoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
@Api(tags = {"PokerPlayerApi"})
@AllArgsConstructor
public class PlayerResource {

    private final PlayerDtoMapper mapper;
    private final PlayerService service;

    @PostMapping
    @ApiOperation("Create a player")
    public PlayerDto createPlayer(PlayerDto toCreate) {
        return mapper.toDto(service.createPlayer(mapper.toModel(toCreate)));
    }

    @GetMapping("/all")
    public List<PlayerDto> getAllPlayer() {
        return mapper.toDtos(service.getAll());
    }

}
