# HalloweenMobHats

Halloween "easter-egg" plugin, where some hostile mobs spawn with Pumpkins on their heads.

It is a very simple plugin without commands or permissions, just a very simple config file and you are set!

## Motivation

Currently I do run a private server for me and my fellow friends where we play semi-vanilla survival in 1.14. 

Even though vanilla is fun, I want to add some additional fun to the game though seasonal events and the first is Halloween, se here is a small spooky plugin for every server owner who wants to spooke his/her players a little bit :D

## Config

### Default config

```yaml
##
# HalloweenMobHats - Small simple plugins to allow mobs to spawn with carved pumpkins or jack'o lanterns on their heads
##

# Allow spawning with carved pumpkins
carved_pumpkin: true

# Allow spawning with Jack'o Lanterns (does not emit light tho)
jack_o_lantern: true

# Chance that mob will drop the head - in percents (e.g. 17.63 = 17.63%), integers only
dropChance: 0.0

# Chance that mob will spawn with a hat - in percents (e.g. 17.63 = 17.63%), integers only
spawnChance: 50

# If mob is wearing a helmet and is set to 'true', helmet will be replaced
ignoreMobHelmet: false

# You can disable an ability of certain mobs to spawn with pumpkins on their heads
mobs:
  zombie: true
  husk: true
  skeleton: true
  stray: true
  wither_skeleton: true
```

_I think that the config itself is self-explaining and does not need any more notes._

## License

This project is released under **MIT** License.