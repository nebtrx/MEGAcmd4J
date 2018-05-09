MEGAcmd for Java
================
This is an open source Java library for the [mega.co.nz][mega] API, working on top of the [MEGAcmd][megacmd] CLI. 

## Features

| Feature                   | MEGAcmd   | Description                                                           
| ---                       | ---       | ---                                                                   
| Start session             | `login`   | Allows to authenticate into the mega api to start running commands using user and password, or sessionID or an exported/public folder  |
| Close session             | `logout`  | Close the current session. 
| Put content in the Cloud  | `put`     | Upload content to the cloud.
| Session Id                | `session` | Returns the id of the current session.
| Idenfity current username | `whoami`  | Returns the username of the current session.
| Make directory            | `mkdir`   | Creates a directory or multiple based on a given remote path.
| List files/directories    | `ls`      | List files and directories in a remote path.
                                            * count of elements
                                            * is there any content
| Get content               | `get`     | Get the content of files and directories in a remote path.
| Copy                      | `cp`      | Copy remote files and directories into a new location.
| Move                      | `mv`      | Move remote files and directories into a new location.
        

If you have any doubt about how each feature works, please run

~~~
    MegaClient <MEGAcmd> --help
~~~

## System requirements
* Install [MEGAcmd][megacmd]. Available packages for MEGAcmd in all supported 
platforms should be found [here][megacmd-install].

### Setup your credentials
1. The most common way to setup your credentials would be using environment variables:
* `MEGA_EMAIL`: Email used as username (lowercase)
* `MEGA_PWD`: Corresponding password

2. Use an existing session can be a saver way. You can use it from your app as long 
as it don't be closed.

## Code conventions

*Java*
* Camelcase as usual for Java code
* Line length is tried (no code checkers) to be kept less than *80* characters. Specially for Java code.


## More information
* Once installed [MEGAcmd][megacmd] in your system execute `mega-help` to check all commands.
You will be able to notice those who are used in this library and others which don't, for practical
reasons, but that will provide you additional capabilities. Try them out.

## Author

* **Eliecer Hernandez** - [eliecerhdz@gmail.com](mailto:eliecerhdz@gmail.com)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

[mega]: https://mega.co.nz
[megacmd]: https://github.com/meganz/MEGAcmd
[megacmd-install]: https://mega.nz/cmd