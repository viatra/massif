%##############################################################################
% Copyright (c) 2010-2018, IncQuery Labs Ltd., logi.cals GmbH, McGill University
% All rights reserved. This program and the accompanying materials 
% are made available under the terms of the Eclipse Public License v1.0 
% which accompanies this distribution, and is available at 
% http://www.eclipse.org/legal/epl-v10.html 
%
% Contributors: 
%     Marton Bur - initial API and implementation 
%##############################################################################
function s = get_all_block_parameters(blockId)
%get_all_block_parameters Gathers all block parameters to a struct
%   The following block parameters are skipped because of adapter limitations:
%    * Capabilities
%    * MaskObject
s=struct();
TmpObjParams=get_param(blockId,'ObjectParameters');
names=fieldnames(TmpObjParams);
for i = 1:numel(names)
    if strcmpi(names{i},'Capabilities') == 0 && strcmpi(names{i},'MaskObject') == 0
        TmpParamValue=get_param(blockId,names{i});
        isReadOnly = find(not(cellfun('isempty', strfind(TmpObjParams.(names{i}).Attributes,'read-only'))));
        if isReadOnly
            [s(:).(strcat(names{i},"_READONLY"))]=TmpParamValue;
        else
            [s(:).(names{i})]=TmpParamValue;
        end
    end
end
