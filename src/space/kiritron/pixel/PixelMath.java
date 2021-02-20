/*
 * Copyright 2020 Kiritron's Space
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package space.kiritron.pixel;

import java.util.Random;

/**
 * @author Киритрон Стэйблкор
 */

// Киритрон: Хотел сначала назвать класс просто Math, но вспомнил, что аналогичный класс имеется в самом Java.
// Чтобы не создавать путаницу, я решил назвать класс PixelMath.
public class PixelMath {
    /**
     * Генерация случайного числа в заданном диапазоне
     * @param min Минимальное значение диапазона
     * @param max Максимальное значение диапазона
     * @return возвращает случайное число в заданном диапазоне
     */
    /* Киритрон: Случайности не случайны
        ...,::cc;'..';:;:::,',,,,,,,;;;;,'''',;;;;;;;'.':c:c::ccccc:'';,'..''''..,;:::::;,...''','''.',;;;;;,'',,;;;;:::cc:,,,;,,,;:cccc;,''....',,,,'...'''''
        ,',;;;::;....,::::;;,;,'.',''';:;;:;,,;:;,;;;;;:ccc:;:ccccc;. .............'',;;;,'''..'''''''',;;;;;,,,,;;;;:::ccc;,'''''',;;;;,'..''';:::;,'''''..''
        ;;,;;;,,'....';::;;;;;........,::::;..',,'',',;;::;;;:ccccc,''...'''........'';;;,,,'...',,,'',,,,,;:;;;;;;;,,;::::;;;,,''',;;,'..';:::::;,;:::c:;,','
        '',;;,...','',;:::::,....''''',,;;;,....''''''''''.';::::;,,,;;,'''''.',,,'',,;;;,,,'..',;,'',,,'',;;;;;;;;;,';:::::;:;;,''.....,:ccccc:::;;:::::;,'''
        .........',,,,::;',;'...,;;,,,,,,,;;,,,;;;;,',;;,'.';:::;,,',,;;,,,,,''''',,,,',,',,''',;;;,'',,'.',;;;;;,,,,',::::::;,,,,,'',;::clcccc:::c:ccc;,,''',
          .......''.'','.  .....',;;,,,,'',;,';::;:;;;::;;'';:;,::;:;;:::;;;;;'..',,,'''.'',;:;;,,;;'''''...';:;;,'',,,,;;,,;,;;;::;:::ccllcc:;;;;;:cc:;,,,'''
                 .  ....      ..',,,,,,,,,,,,',;;;;,,;::c:;,;:,,:::;,;;:;;:c:c:..',,,,,,'..';cc:;;;;;;'..'...,;,,'',,,,,;,'.',,,;:;;;;;:::::'..,;,',;;,,,'',;;
                            ...',,'''''''',;:;;::;;;;:ccc:;;;:;,,,,........,;;;....',::;,,.';c::;,,;:;'........',,,,,;;;;;;'..',;;;;;;;;:::;..';;,',;;,'..':::
                 ...        ..',,'........',;;;;;;;;:cccc:;;:,'................''...';::::;'',;;;;;:c;'''''''..',,;;;,;:::;;,'',,;;;:::::;;,..,;;,'';;;::;;:c:
             .........     ..'',,'..  ......'''';cccccccc::cc;...........'',....'''...''',;;,'',;;;:;,,'''......''',,,,;:::;,''',,,',;;;,',,,,,;;,',;;;;:::::,
           ........       ..',,,,,,,'.......';;,;::ccccccc::c:. .......';,..'............';;;,'.',;;,'...............',,;:::,''',,,,,,,'''',,,;;;,'',;;:::;,.
            .         ..    .;;;;;;;,,.   .,cccc:;;;ccccccc:c:'      ..';;,...............,;;;;'.',;;,........'..'''',,,;::;,'',;;:::;,,,,,,,;;;;,,',;;::,..
                     ...    ....,;;;,',,'';cc:ccccc::ccc:,,:cc:.       .......',,'..''...',,,;;;,'',;;,..........'''''',,,,,,'.',;::c:;,,;;,,,,,,,;,''',,'.'..
        . ............          .,;;,,;;::::::ccccc:;:::cc:,,;;,.....       ..,;;;;;;;,''',,,;;,,,;:cllcccccc::;;,,'...,,,,,,,,',::;,::;;;;,,,,'',,,'''','',,,
          ............ ....  ....';;,'.',,,,'',:cc::;;:ccll;.......'.......';:clllllllc:;,,,;;;:cccccccccccllllooolc:;''..........'.',,',;;;,;;,;;;,,;:::;''',
          .. .''........;c:,..',,,;;;;,...   .,::;;:;;;:c:;. ........';:cclllc:;;;;;;;;:::,..',,'............'',,;;:clc:,.............''''.';;;;;;;;;::::;,,'.
         .   .;c:,. .;::::::;;::;;:::,....',',;;::cc:;;;,..       .,:ccc:;,'..............'. .....        ..........',,;;,............''...';;,;;::::::cclc;'.
        ......;c::,..,;::;::;,,:::ccc:;:lol;,;;;;;::c::;;,'......,:c;,'.........          .......                 ..........         .....',,,',;:::::;;:;,'.'
        ....':cc::;..',;;:c::,'':lodddllll,.',,,,;;:cc:;;;,''',,,;,'.... .                 ....                      ........','..  ........',,,;::::;,,,,,,,'
        .....';;::;,,;;;:::;;,.,coooooccc:'...'',,;;;;;,,'....,c:,......                    ..                        ... ..;clolc:;;::::;,,,,,,,,,.. ....''..
        ........,,,,,,,;::,''..,:cllllc::;....''..'''.'''...  .;cc;..                       ...                           .....',;ccllc::::;,,,,;;,.         .
            ....'','',,,,,''...';;cc,,cc:;.....,;;:lxOOO000kd;.,c:::.                       .,,.                         ....  ....';:lll:;;;;;;;;,.        .'
               ...''''''',''...',;cc;,::::'. .ldl,.':kXXXXXXX0:'cccc;..                      ',.                         .         ...',:ccc::;,,,,. ..''...''
                ...';;,'....'..';:clcllc::,. :xd:. .;dKXXXXKKx''cccloo:,.                    ..                                        ..';:cc;'..   .,,,'''''
        .       .:oxkd:...,;,..':cclolllc::'..,:lccoxO00Oxoc,..,:clodxo:;'.                                                             ...';:c;.....'''''''''
                .oxkkd:..;lxd'.':cllllllc::;.   ...',,,,'.....;c:clodxdc;;;'.                                                              ..';:,........',,,,
                .,odxdolc:;;'...,;cccllc::::;'. .....'',,,''';cccllllddc;;;;,.                                                              ...,,........,,,''
        .         ..............';ccclolcc::;;'...........',;:cc:;clcll::::::;.                                                               ..'......''''...
                .  ..............,:ccllllc:::;;,,,'..'''',;:cc:'.;llllc::::;:::'                                                               ..',,,,'.......
                    ............',:cccllllcccc:::::;;:c::ccc;. .:oooolcc:::;;;;;,.                                                             ..''',;,''''...
                ..  ...'......''',:ccccloollollllllllool:;'.  .:oodddoc:::::;;;,,,.                                                            ..''',::;,'....
              .     ...''..''',,,;cclodxxxxxxxddddoll:;'..  ':lloddxxdc:c:::;;;;,,,'.                                                          .''';:lol:'....
                      .;,..'',,;::cloodddddololccc;,'....';codddddxxxdl:::;::::;;,,,'.                                                        .'....';:clc,...
        ...           .:;.....',,;;::ccc:;;;;;;;,'''';:lodddddxxxxxxxoccc:,,;;;::;,','.                                                       ..    ..';:c:'..
        ....       .. .:c;.    .....''',,,,,;;:c:loodxdxxxxxxddxxxxxxllllc:::;;,;;,,,,'.                                                              ..,;:;''
        .......       .,cll:;,,;;;;;:ccllloodxxxdoxkkkxxxkxxxxddxxxxoooollc::::;,,,;;,,.                                                               ..',;,'
        ............. ..';cllloddodoooodoodddxxkkxkOkOkkxxxxxxxxkxxddddollcccc::;,',,,''.                                                                ..',,
        ..................;::clodddolollllodddxkkkOOOOkkkxxkkkkxxddxkxddoolc:::::;,'.''',.                                                                ...'
        ..................'::clloddocllllcloddxxkOOOOOOOkkxxkxdoooooooddddolcc::::;,'',',,'                                                                ...
        ..................':::clclddlcoolccoddxkOkOOOkkOkxxxddolllcllooooooolcc::::;;'',,;;,.                                                              ...
        ...................':ccllloddoodolllooddxdxxxddxxxxxxddoolllloollloollcc:;;;;'';;;;,,'.                                                            ...
        ..     ....        ..',;:ccclloddoooodddddxxdxxxxkkkxxdddooolllllllcccccc:;:;,,,,,,,;;;'.                                                        ...
                              ........';:coddddxxxxkkkkkkkkkxxxxddoollllllccccc:::;:;:;,';;,;;;;;'.                                                     ..,;;,
                             ............',;:cloxxkkkkkkkkxxxxxxxdooollclllllcccc:;;;;:;,,;;;:::::;,..                                                   ..,:c
                              ........';c:,'.....',,,,';codxxxxxxdddollllllcccccc::;;;;:;,',::;;::;::;,'..                                                 .';
                                .....,cc:'..             ..';clddddooolllcccccc::::::;;;;;,,,,;;;;;,;:;;::;,'.                                              .'
                                ....'::;..                     .';::cclllc::cccc:::::;;;;;;;;,';::;,,:::::;:::;,'..                                          .
                                 ...';;'.                        .';;;:cclcc::ccc::;:::;;;;;::;,,;;;;;;;;::;;::;;;;,'..
                   ...          .....''.                          .';;;;:cccc::ccc::::::;;;,;;;;,'';;;;;,;::;;::;;;::::,'..
                                 .......                        .....,;,;;::cc:::ccc::;;;;,,,;:::;,''';;;;;;;;::c:;::;;:::;,.
                                ....  .                        .,'....,,,;,;;::::::c:::;,;;,,,;;,;:;'.',;;::;;;;:::;;;;;;:::;;'.
                               .,;'..  ...                   .,,'......,,,,,,;;::::::::;;,,;;;;;;;:::;;,'';:;;;;;;;:cc:;;;::;::;'.                           .
                               ':;'...,;;,..              ..,;'''......''',,',,,;:;;;;;;;,,,;;;;;;;;::;;;;;:;;;::;;::::;;:::;:::;,.
                               ';,...',,..               .,;;;,''..........'..'',;;;;,,;;;,,'',,;:::;;;::;:;,'',;:;;:;;,;:cc:;:::;;'.
                               .''.. ..                .';;,'','................',;;;,',,,,,,'''',;:;;;::,,::;,,;::::;;,;:::::;:::::;.
                                ....                 .',;;;'',,..................',,,,'',,,,,,,'.',;;,;:::::::::;;;::;,,;;;,;::::;;:;,.
        c:;'..                ...''..               .,;;;,,',,,....................''',,',,,,,,,,'.',;;::cc::;:c::;;;;;,;:;;,;::;;;:;;,'.
        oodool:,..             .;:;,.  .           .,,,,,,,'''.'...................'',,,,,,;;;,,,,'',;;;:cc:::c::::;;;:::;,;;:::;;;;;;;,,'.
        ooooooool:,.            .,;'.','.         .,,'',,,,,'..''..................'',,;;,,;;;;,,;,'',;;;::;,,;:;;;:c:;;;,,,;;;;:;;;,,,,,,'..         .';;.
        ddooooolllll:'.         ..,,,..,'.       .,,,'',''',''..................'..'',,,;;,,;;:;;;;;,,;;,,,,,,;:c:::::;,;;;;;;:;;;,,,,,,,,,''..   .';cllc:,.
        dooooollllllllc'.        .;:;'.;lc:;..  .,,''',,,''.'''.................'.'',,,,;;;,;::;;;:;;,',,;;,;;;;:::;;;;;;:::;;;,,,,,,'.',,''''',;clllc:;,,'.
        oooooolllllllllc:'. ......';;,...,cooc;,,,'''..'','','...................''',,,;;;;;;;:::::;;;,',;;,;;:;;;,;;,;,,,:;,,,'',,',..','';clooolc:;,,,,,.
        oooooollllllllcccc;........,;;'  ..,:cloc,','...........................''''',,;;;:;;;:;;;;;;;;;,',;;;;,;:;,;;;;;;::;,,;;,,,'',:c:,,clcc:;;,,,,,'.
        oooololllllllccccc::,......':;,.   ..',;,,::;,''..'''.....  .............''.',,,;;;;;,;;;;::;;;;,,,,,,,,,;;;::::;;;;,,,;;,:cloddol:'':;;;,,,,,,,'.
        oooollllollllccccc:::;...  .,;;'.   .....',,,,'..........   .  ..........'...',,,;;:;;,;;;;;;;;;,,'',;;,',,;;;::;,,,,;:lloddoolcc::,',;;,,,,,,',::;,..
        oooolollllllllcc::::::;.   .',;;'.   ......'''............     ..............'',,,;;;;,,;;;;;;;,,,,'',,,,,,;;;,,;:clloooolccc::::::'',;;;;;,,'';lolcc:
        ooollllllllllcccc:::;::,.  ...,,,.   .''....''''..........   ................''',,;;;;,,,;;;,,,,',,'''',;::c:;';looolcccc:::::::::;'';;;;;;,,',:c:ccll
        ooollllllllcccccc::;;:;;'......',,. .''.....'''',,,''.....  ........''',,,,,,,,,,,,;;;,,,,;;;;;::cccclloooool;.':cccc:::::::::::::,.,;;;;;;,,,:c::::cl
        oolllllllllcccc:::::;::;,'.  ...,,..','''....''',,,,,,,,,'..........',;::cclllllllc:,,;clllooooooooollllllccc:'.,:::::::::::::::::'.,;;;;;,,',:c::cc;;
        llllllllclccccc:::::;;;;;'.   ..'''..'''... ..''',,,;,,;;;,'',,''..''',;;::::clllll:..;llllllllcccccccccc:c:::,.,cccc::::::::::::;',;;;;;,,'',;;;::::;
        llllccccccccc::::::::;;;;'.   ..'''...''...   .'',,,,,;;;;;;,,;;;;,,,,,;;;;;;;:::::;..,::cc::::::::ccc::c:::c:,';ccccccccccc:::::,',;;;,,,,''',;,,;,;:
        ;;;;,'''.'',::::;;;;;;;;;'. .....''....,'..    .',,,,,,;;;;;;,';;;;;;;:::;;::;;;::::'.';:::::::cccccc:::::ccc:'';cccccccccccc:cc:,',;,,,,,,,'..''.''',
        .'.........,:::;;;;;;;;;,'.......'''....'..    ..',,,,,,,,;;;;,';::::::::::::::::::::,';::ccccccccccccccccccc:'':cccc::::cccc::::'',,,,,,,,''..''''..'
        .....',,;:::::;;;;;;;;;;,'........'.........    ..',,,,;,,,;;;;'';:;::::::::::::::::::,';cccccccccccccccccccc:',cccccc::::ccc:::;;;;;;;;;,,,''''','...
        ;:cclcccc::::;;;;;;:;:;;,'..'......... .....   . ...',,;;;;;,;;,.,::::::::::::::::::::;';cccccccccccclccccccc;';cccccccccccc:;;;:;;;;;;;,,,,,''''''...
     */
    public static int genRandom(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    // Киритрон: Не знаю, буду ли я ещё что-то добавлять сюда.
}