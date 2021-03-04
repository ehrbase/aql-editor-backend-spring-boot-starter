package org.ehrbase.aqleditor.service.ehrbase;

import java.util.Optional;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;

public class FakeEhrTemplateProvider implements TemplateProvider {

  @Override
  public Optional<OPERATIONALTEMPLATE> find(String templateId) {
    return Optional.empty();
  }

}
