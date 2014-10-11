function libraryNames = library_collector()

slblocksLocations = which('slblocks','-ALL');
sizeMat = size(slblocksLocations);
locationCount = sizeMat(1);

libraryNames = cellstr('');

%For each slblocks file open the corresponding libraries
for j=1:locationCount
    
    fileName = slblocksLocations(j);
    fileName = fileName{1,1};
    fileHandle = fopen(fileName);
    %fileContent = fscanf(fileHandle,'%c')
    fileContent = '';
    
    
    tline = fgets(fileHandle);
%     isComment = regexp(tline,'^\s+%');
%         
%     if(~isempty(isComment))
%         fileContent = tline;
%     end
    

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
        
    
        potentialName = fileContent(nameStartIndex(k):length(fileContent)) ;   
        
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
    

