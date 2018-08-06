%##############################################################################
% Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill
% University, Embraer S.A., Budapest University of Technology and Economics
% All rights reserved. This program and the accompanying materials 
% are made available under the terms of the Eclipse Public License v1.0 
% which accompanies this distribution, and is available at 
% http://www.eclipse.org/legal/epl-v10.html 
%
% Contributors: 
%     Marton Bur - initial API and implementation 
%##############################################################################
function massif = massif_functions()
%MASSIF_FUNCITONS Summary of this function goes here
%   Detailed explanation goes here

massif.library_collector=@library_collector;
massif.get_all_block_parameters=@get_all_block_parameters;

end

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
end

function s = get_all_block_parameters(blockId)
%get_all_block_parameters Gathers all block parameters to a struct
%   The following block parameters are skipped because of connector limitations:
%    * Capabilities
%    * MaskObject

s=struct();
TmpObjParams=get_param(blockId,'ObjectParameters');
names=fieldnames(TmpObjParams);
for i = 1:numel(names)
    if strcmpi(names{i},'Capabilities') == 0 && strcmpi(names{i},'MaskObject') == 0
        TmpParamValue=get_param(blockId,names{i});
        isReadOnly = sum(strcmp(TmpObjParams.(names{i}).Attributes,'read-only'));
        isNeverSave = sum(strcmp(TmpObjParams.(names{i}).Attributes,'never-save'));
        if (isReadOnly + isNeverSave) > 0
            [s(:).(strcat(names{i},"_READONLY"))]=TmpParamValue;
        else
            [s(:).(names{i})]=TmpParamValue;
        end
    end
end
end 
