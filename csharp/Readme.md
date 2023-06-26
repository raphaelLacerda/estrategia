docker run -v $(pwd):/home -it mcr.microsoft.com/dotnet/sdk:6.0 /bin/bash

dotnet new console -o ola-mundo
dotnet run