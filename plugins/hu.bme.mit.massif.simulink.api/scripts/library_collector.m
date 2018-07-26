%##############################################################################
% Copyright (c) 2010-2013, Embraer S.A., Budapest University of Technology and Economics
% All rights reserved. This program and the accompanying materials 
% are made available under the terms of the Eclipse Public License v1.0 
% which accompanies this distribution, and is available at 
% http://www.eclipse.org/legal/epl-v10.html 
%
% Contributors:
%     Marton Bur - initial API and implementation 
%##############################################################################
function libraryNames = library_collector()
%library_collector Searches for all block libraries visible to MATLAB

slblocksLocations = which('slblocks','-ALL');
sizeMat = size(slblocksLocations);
locationCount = sizeMat(1);

libraryNames = cellstr('');

%For each slblocks file open the corresponding libraries
for j=1:locationCount
    
    fileName = slblocksLocations(j);
    fileName = fileName{1,1};
    fileHandle = fopen(fileName);
    fileContent = '';
    
    tline = fgets(fileHandle);

    % purify the file - remove unnecessary lines
    while ischar(tline)
        isComment = regexp(tline,'^\s*%', 'once');
        isBlank = regexp(tline,'^\s*\n', 'once');
        if(isempty(isComment) && isempty(isBlank))
            %disp (tline)
            fileContent = strcat(fileContent, tline);
        end
        tline = fgets(fileHandle);
    end
    
    % Get matching locations
    [~,endIndex] = regexp(fileContent,'Browser\([0-9]+\)\.Library([ ]*[\t]*)*=([ ]*[\t]*)*''');
    nameStartIndex = endIndex+1;
    
    for k=1:length(nameStartIndex)
        
        potentialName = fileContent(nameStartIndex(k):length(fileContent));   
        [~,endIdx] = regexp(potentialName,'''');
        
        libraryName = potentialName(1:endIdx-1);
        if(~isempty(libraryName))
            % "return value"
            libraryNames = [libraryNames , libraryName];
        end
        
    end
    
    fclose(fileHandle);
end

libraryNames = libraryNames(2:length(libraryNames));
    

