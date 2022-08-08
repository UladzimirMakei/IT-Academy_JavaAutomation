package com.it_academy.tests.ui.parallel_browsers;

import com.it_academy.tests.ui.parallel_browsers.local.OnlinerCatalogLocalParallelTest;
import com.it_academy.tests.ui.parallel_browsers.remote.OnlinerCatalogRemoteParallelTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses( { OnlinerCatalogRemoteParallelTest.class,
        OnlinerCatalogLocalParallelTest.class} )

public class SuiteLocalRemoteParallelExecution {
}
